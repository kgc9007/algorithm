-- 코드를 입력하세요
SELECT ins.ANIMAL_ID, ins.NAME
FROM ANIMAL_INS as ins, ANIMAL_OUTS as outs
WHERE ins.ANIMAL_ID = outs.ANIMAL_ID
AND outs.DATETIME < ins.DATETIME
ORDER BY ins.DATETIME;