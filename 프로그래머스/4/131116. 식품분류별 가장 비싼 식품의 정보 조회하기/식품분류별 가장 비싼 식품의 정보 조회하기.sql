SELECT F.CATEGORY, F.PRICE AS MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT F JOIN 
(SELECT CATEGORY, MAX(PRICE) PRICE
FROM FOOD_PRODUCT
GROUP BY CATEGORY) A
ON F.CATEGORY = A.CATEGORY AND F.PRICE = A.PRICE
WHERE F.CATEGORY IN ('과자', '국', '김치', '식용유')
ORDER BY F.PRICE DESC