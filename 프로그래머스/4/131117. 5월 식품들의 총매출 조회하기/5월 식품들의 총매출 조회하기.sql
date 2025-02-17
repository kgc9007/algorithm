-- 코드를 입력하세요
-- 생산일자가 2022년 5월인 식품들의
-- 식품 ID, 식품 이름, 총매출
-- 총매줄 기준 내림차순, 총매출이 같다면 식품 ID 기준 오름차순

SELECT 
    o.PRODUCT_ID, 
    p.PRODUCT_NAME, 
    SUM(o.AMOUNT * p.PRICE) AS TOTAL_SALES
FROM 
    FOOD_PRODUCT p 
    JOIN 
    FOOD_ORDER o
ON p.PRODUCT_ID = o.PRODUCT_ID
WHERE SUBSTR(o.PRODUCE_DATE, 1, 7) = '2022-05'
GROUP BY o.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, PRODUCT_ID ASC;

# SELECT *
# FROM FOOD_ORDER
# WHERE SUBSTR(FOOD_ORDER.PRODUCE_DATE, 1, 7) = '2022-05';