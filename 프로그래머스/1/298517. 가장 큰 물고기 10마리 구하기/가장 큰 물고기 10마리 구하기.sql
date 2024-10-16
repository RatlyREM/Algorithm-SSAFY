WITH FISHES AS (
    SELECT ID, LENGTH
    FROM FISH_INFO
    WHERE LENGTH IS NOT NULL AND ID NOT IN (4,5)
    ORDER BY LENGTH DESC, ID
    LIMIT 10
)

SELECT *
FROM FISHES