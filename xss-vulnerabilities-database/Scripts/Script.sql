DROP TABLE IF EXISTS t_responses;
DROP TABLE IF EXISTS t_instructions;

CREATE TABLE t_responses (
	id_response int generated ALWAYS AS IDENTITY,
	firstname varchar(10),
	response varchar(1000)
);
CREATE TABLE t_instructions (
	id_instruction int generated ALWAYS AS IDENTITY,
	name varchar(50)
);