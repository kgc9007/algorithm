-- 코드를 작성해주세요
SELECT YEAR(A.DIFFERENTIATION_DATE) AS YEAR, ABS(A.SIZE_OF_COLONY - B.MAX_SIZE) AS YEAR_DEV, A.ID as ID
FROM ECOLI_DATA A
LEFT JOIN
(SELECT MAX(SIZE_OF_COLONY) AS MAX_SIZE, YEAR(DIFFERENTIATION_DATE) AS YEAR
FROM ECOLI_DATA
GROUP BY YEAR(DIFFERENTIATION_DATE)) B
ON YEAR(A.DIFFERENTIATION_DATE) = B.YEAR
ORDER BY YEAR, YEAR_DEV ASC;