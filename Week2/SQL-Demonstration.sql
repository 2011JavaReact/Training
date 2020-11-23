SELECT *
FROM accounts a

SELECT *
FROM orders o
WHERE total_amt_usd >= 10000 AND total_amt_usd <= 20000;

-- Derived columns
SELECT id, account_id, standard_amt_usd / standard_qty as unit_price
FROM orders
WHERE standard_qty > 0;

SELECT *
FROM accounts a
WHERE a.name LIKE '_C%';

SELECT *
FROM accounts a 
WHERE a.name LIKE '%one%';

-- IN Clause
SELECT *
FROM accounts a 
WHERE name IN ('Walmart', 'Target', 'Nordstrom');

SELECT *
FROM accounts a 
WHERE name NOT IN ('Walmart', 'Target', 'Nordstrom');

SELECT *
FROM web_events we 
WHERE occurred_at BETWEEN '2016-01-01' AND '2017-01-01';

-- Aggregate
SELECT account_id, SUM(total_amt_usd)
FROM orders o
GROUP BY account_id;

SELECT account_id, SUM(total_amt_usd)
FROM orders o
GROUP BY account_id
ORDER BY SUM(total_amt_usd) desc 
limit 10;


CREATE OR REPLACE VIEW demo_view AS (
	SELECT account_id, SUM(total_amt_usd) as spending
	FROM orders o
	GROUP BY account_id
	ORDER BY SUM(total_amt_usd) desc 
	limit 10
);

SELECT *
FROM demo_view

SELECT m.spending
FROM (
	SELECT account_id, SUM(total_amt_usd) as spending
	FROM orders o
	GROUP BY account_id
	ORDER BY SUM(total_amt_usd) desc 
	limit 10
) m


CREATE TABLE my_table (
	id INTEGER PRIMARY KEY,
	name VARCHAR(255) NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS my_table_pk_sequence 
	MINVALUE 1000
	NO MAXVALUE
	START WITH 1000
	NO CYCLE
	OWNED BY my_table.id;
	
CREATE OR REPLACE FUNCTION set_my_table_id() RETURNS trigger 
AS
$$
BEGIN
	NEW.id = NEXTVAL('my_table_pk_sequence');
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_my_table_pk
BEFORE INSERT
ON my_table
FOR EACH ROW
	EXECUTE PROCEDURE set_my_table_id();
	

INSERT INTO my_table (name) VALUES ('YellowBeard');

SELECT *
FROM my_table mt 


CREATE TABLE pirates (
	id SERIAL GENERATED ALWAYS AS IDENTITY,
	name VARCHAR(255) NOT NULL
);

