SELECT PRODUCT_CODE, SUM(SALES_AMOUNT * PRICE) AS SALES
FROM OFFLINE_SALE OS JOIN PRODUCT PR
ON OS.PRODUCT_ID = PR.PRODUCT_ID
GROUP BY PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE
