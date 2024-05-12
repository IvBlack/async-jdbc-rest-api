CREATE OR REPLACE FUNCTION batch_procedure(
    IN input_date DATE, IN batch_size INTEGER
)
RETURNS VOID AS $$
DECLARE
    batch_size INTEGER := 10000;
    row_count INTEGER;
BEGIN
    LOOP
        BEGIN
            DELETE FROM movie
            WHERE release_date < input_date
            AND release_date IN (
                SELECT release_date
                FROM movie
                WHERE release_date < input_date
                ORDER BY release_date ASC
                LIMIT batch_size
                FOR UPDATE SKIP LOCKED
            );

            GET DIAGNOSTICS row_count = ROW_COUNT;

            IF row_count = 0 THEN
                EXIT;
            END IF;

            COMMIT;

            -- Optional: Sleep for a short duration to allow other transactions
            -- to access the table in between batches.
            PERFORM pg_sleep(0.6);
        END;
    END LOOP;
END;
$$ LANGUAGE plpgsql;