--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-06-22 00:57:18

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2844 (class 1262 OID 16393)
-- Name: places; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE places WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';


ALTER DATABASE places OWNER TO postgres;

\connect places

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 6 (class 2615 OID 16394)
-- Name: places_app; Type: SCHEMA; Schema: -; Owner: app_user
--

CREATE SCHEMA places_app;


ALTER SCHEMA places_app OWNER TO app_user;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 206 (class 1259 OID 16469)
-- Name: cities; Type: TABLE; Schema: places_app; Owner: app_user
--

CREATE TABLE places_app.cities (
    id numeric NOT NULL,
    name character varying NOT NULL,
    latitude double precision NOT NULL,
    longitude double precision NOT NULL
);


ALTER TABLE places_app.cities OWNER TO app_user;

--
-- TOC entry 208 (class 1259 OID 16492)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: places_app; Owner: app_user
--

CREATE SEQUENCE places_app.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE places_app.hibernate_sequence OWNER TO app_user;

--
-- TOC entry 209 (class 1259 OID 16494)
-- Name: my_seq_gen; Type: SEQUENCE; Schema: places_app; Owner: app_user
--

CREATE SEQUENCE places_app.my_seq_gen
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE places_app.my_seq_gen OWNER TO app_user;

--
-- TOC entry 203 (class 1259 OID 16404)
-- Name: places; Type: TABLE; Schema: places_app; Owner: app_user
--

CREATE TABLE places_app.places (
    id numeric NOT NULL,
    name character varying NOT NULL,
    city_id numeric NOT NULL
);


ALTER TABLE places_app.places OWNER TO app_user;

--
-- TOC entry 2836 (class 0 OID 16469)
-- Dependencies: 206
-- Data for Name: cities; Type: TABLE DATA; Schema: places_app; Owner: app_user
--

INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (1, 'Florence', 43.7800148, 11.2059485);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (2, 'Vienna', 48.220778, 16.3100205);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (3, 'Edinburgh', 55.9412846, -3.275378);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (4, 'Prague', 50.0598058, 14.3255419);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (5, 'Moscow', 55.5815245, 36.8251381);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (6, 'Bruges', 51.2608054, 3.0820632);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (7, 'Verona', 45.4263052, 10.957512);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (8, 'Annecy', 45.8899344, 6.0934832);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (9, 'Budapest', 47.4813602, 18.9902207);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (10, 'Barcelona', 41.3948976, 2.0787282);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (11, 'Amsterdam', 52.3547498, 4.833921);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (12, 'Paris', 48.8589507, 2.2770204);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (13, 'Mykonos', 37.444475, 25.3268288);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (14, 'Valletta', 35.8984892, 14.5087876);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (15, 'Copenhagen', 55.6713442, 12.5237846);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (16, 'Stockholm', 59.326242, 17.8419717);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (17, 'Tallinn', 59.4717925, 24.5981607);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (18, 'Alesund', 62.4681226, 6.1714089);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (19, 'St Petersburg', 59.940461, 29.8145008);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (20, 'Zurich', 47.3775499, 8.4666755);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (21, 'Lisbon', 38.7436883, -9.1952226);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (22, 'Strasbourg', 48.5692059, 7.6920545);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (23, 'Ghent', 51.082572, 3.5744032);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (24, 'Rome', 41.9102415, 12.395915);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (25, 'Dubrovnik', 42.6457874, 18.0765377);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (26, 'Warsaw', 52.2330653, 20.9211124);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (27, 'Reykjavik', 64.1335484, -21.9224813);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (28, 'Venice', 45.4551712, 12.251929);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (29, 'Antwerp', 51.2194622, 4.3937067);
INSERT INTO places_app.cities (id, name, latitude, longitude) VALUES (30, 'London', 51.5287718, -0.2416804);


--
-- TOC entry 2835 (class 0 OID 16404)
-- Dependencies: 203
-- Data for Name: places; Type: TABLE DATA; Schema: places_app; Owner: app_user
--



--
-- TOC entry 2845 (class 0 OID 0)
-- Dependencies: 208
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: places_app; Owner: app_user
--

SELECT pg_catalog.setval('places_app.hibernate_sequence', 30, true);


--
-- TOC entry 2846 (class 0 OID 0)
-- Dependencies: 209
-- Name: my_seq_gen; Type: SEQUENCE SET; Schema: places_app; Owner: app_user
--

SELECT pg_catalog.setval('places_app.my_seq_gen', 1, false);


--
-- TOC entry 2707 (class 2606 OID 16476)
-- Name: cities cities_pkey; Type: CONSTRAINT; Schema: places_app; Owner: app_user
--

ALTER TABLE ONLY places_app.cities
    ADD CONSTRAINT cities_pkey PRIMARY KEY (id);


--
-- TOC entry 2705 (class 2606 OID 16411)
-- Name: places places_pkey; Type: CONSTRAINT; Schema: places_app; Owner: app_user
--

ALTER TABLE ONLY places_app.places
    ADD CONSTRAINT places_pkey PRIMARY KEY (id);


--
-- TOC entry 2708 (class 2606 OID 16477)
-- Name: places cities_fk; Type: FK CONSTRAINT; Schema: places_app; Owner: app_user
--

ALTER TABLE ONLY places_app.places
    ADD CONSTRAINT cities_fk FOREIGN KEY (city_id) REFERENCES places_app.cities(id) NOT VALID;


-- Completed on 2020-06-22 00:57:18

--
-- PostgreSQL database dump complete
--

