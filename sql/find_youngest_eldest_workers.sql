SELECT 'YOUNGEST' AS TYPE, NAME, BIRTHDAY
FROM Worker
WHERE BIRTHDAY = (SELECT MIN(BIRTHDAY) FROM Worker)
UNION ALL
SELECT 'ELDEST' AS TYPE, NAME, BIRTHDAY
FROM Worker
WHERE BIRTHDAY = (SELECT MAX(BIRTHDAY) FROM Worker);