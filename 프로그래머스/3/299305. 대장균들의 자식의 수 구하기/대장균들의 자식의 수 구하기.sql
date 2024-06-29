SELECT ED.ID, IF(CI IS NULL, 0, CI) AS CHILD_COUNT 
FROM ECOLI_DATA ED LEFT JOIN
(SELECT PARENT_ID, COUNT(ID) CI
FROM ECOLI_DATA
WHERE PARENT_ID IS NOT NULL
GROUP BY PARENT_ID) A
ON ED.ID = A.PARENT_ID
ORDER BY ED.ID