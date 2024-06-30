SELECT ID, IF(LI/TC <= 0.25, 'CRITICAL', IF(LI/TC <= 0.5, 'HIGH', IF(LI/TC <= 0.75, 'MEDIUM', 'LOW'))) AS COLONY_NAME
FROM 
(SELECT ID, SIZE_OF_COLONY, RANK() OVER(ORDER BY SIZE_OF_COLONY DESC) LI, COUNT(*) OVER() AS TC
FROM ECOLI_DATA
ORDER BY SIZE_OF_COLONY DESC) A
ORDER BY ID


