DELETE FROM t_responses;
DELETE FROM t_instructions;

INSERT INTO t_responses (firstname, response) VALUES ('Anonymous', 'Hello P4!');
INSERT INTO t_instructions (name) VALUES ('Say hello !');

SELECT * FROM t_instructions ti;
SELECT * FROM t_responses tr;