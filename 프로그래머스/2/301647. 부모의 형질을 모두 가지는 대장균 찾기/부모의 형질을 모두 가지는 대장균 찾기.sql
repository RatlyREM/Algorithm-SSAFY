# 부모의 GENOTYPE과 AND연산 해봤을 때 부모가 나오면 갖고있는거임.

SELECT ED1.ID, ED1.GENOTYPE GENOTYPE, ED2.GENOTYPE PARENT_GENOTYPE
FROM ECOLI_DATA ED1, ECOLI_DATA ED2
WHERE ED1.PARENT_ID = ED2.ID
AND ED1.PARENT_ID IS NOT NULL
AND ((ED1.GENOTYPE & ED2.GENOTYPE) = ED2.GENOTYPE) 
ORDER BY ED1.ID