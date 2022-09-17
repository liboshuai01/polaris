-- 2018~2026随机日期
SELECT ADDDATE(
               ADDDATE(
                       ADDDATE(ADDDATE(ADDDATE(ADDDATE('2018-01-01 00:00：00', INTERVAL FLOOR(RAND() * 8) YEAR),
                                               INTERVAL FLOOR(RAND() * 12) MONTH),
                                       INTERVAL FLOOR(RAND() * 31) DAY), -- 1-30号
                               INTERVAL FLOOR(RAND() * 24) HOUR),-- 0-23点
                       INTERVAL FLOOR(RAND() * 60) MINUTE
                   ),-- 0-59分
               INTERVAL FLOOR(RAND() * 60) SECOND -- 0-59秒

           ) rand_time;

-- 2022-09-17以前的随机时间
SELECT ADDDATE(
               ADDDATE(
                       ADDDATE(ADDDATE(ADDDATE(ADDDATE('2022-09-17 22:00：00', INTERVAL FLOOR(1 -(RAND() * 4)) YEAR),
                                               INTERVAL FLOOR(1 - (RAND() * 12)) MONTH),
                                       INTERVAL FLOOR(1 - (RAND() * 31)) DAY),
                               INTERVAL FLOOR(1 - (RAND() * 24)) HOUR),
                       INTERVAL FLOOR(1 - RAND() * 60) MINUTE
                   ),
               INTERVAL FLOOR(1 - (RAND() * 60)) SECOND

           ) rand_time;

-- date 2018~2026随机日期
select ADDDATE(ADDDATE(ADDDATE('2018-01-01', INTERVAL FLOOR(RAND() * 8) YEAR),
                       INTERVAL FLOOR(RAND() * 12) MONTH),
               INTERVAL FLOOR(RAND() * 31) DAY) rand_time;

select ADDDATE(ADDDATE(ADDDATE(ADDDATE(ADDDATE(ADDDATE('2018-01-01 00:00：00', INTERVAL FLOOR(RAND() * 8) YEAR),INTERVAL FLOOR(RAND() * 12) MONTH),INTERVAL FLOOR(RAND() * 31) DAY), INTERVAL FLOOR(RAND() * 24) HOUR),INTERVAL FLOOR(RAND() * 60) MINUTE),INTERVAL FLOOR(RAND() * 60) SECOND) rand_time;


-- i ≤ R ≤ j 这个范围得到一个随机整数R ，需要用到表达式 FLOOR(i + RAND() * (j – i + 1))
-- 0~1随机数
select ADDDATE(ADDDATE(ADDDATE('00:00:00', INTERVAL FLOOR(RAND() * 24) HOUR),INTERVAL FLOOR(RAND() * 60) MINUTE),INTERVAL FLOOR(RAND() * 60) SECOND) rand_time;