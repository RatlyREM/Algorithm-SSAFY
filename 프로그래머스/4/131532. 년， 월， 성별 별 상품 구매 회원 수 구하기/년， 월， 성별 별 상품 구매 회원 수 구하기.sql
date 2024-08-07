SELECT Y AS YEAR,M AS MONTH, GENDER, COUNT(*) AS USERS
FROM
(SELECT USER_ID, YEAR(SALES_DATE) Y, MONTH(SALES_DATE) M
FROM ONLINE_SALE
GROUP BY USER_ID, Y,M) A JOIN USER_INFO UI
ON A.USER_ID = UI.USER_ID
WHERE GENDER IS NOT NULL
GROUP BY Y,M,GENDER
ORDER BY YEAR, MONTH, GENDER


# SELECT OS.USER_ID, YEAR(SALES_DATE) Y,  MONTH(SALES_DATE) M, GENDER
# FROM ONLINE_SALE OS JOIN USER_INFO UI
# ON OS.USER_ID = UI.USER_ID
# WHERE GENDER IS NOT NULL
