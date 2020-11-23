--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-11-23 16:53:12

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 206 (class 1259 OID 32968)
-- Name: details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.details (
    id bigint NOT NULL,
    serialnumb character varying,
    amount integer,
    id_zakaz integer
);


ALTER TABLE public.details OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 32966)
-- Name: details_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.details_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.details_id_seq OWNER TO postgres;

--
-- TOC entry 2846 (class 0 OID 0)
-- Dependencies: 205
-- Name: details_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.details_id_seq OWNED BY public.details.id;


--
-- TOC entry 204 (class 1259 OID 32953)
-- Name: specification; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.specification (
    serialnumb character varying NOT NULL,
    name character varying,
    specific character varying,
    createdate timestamp with time zone
);


ALTER TABLE public.specification OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 32920)
-- Name: zakaz; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.zakaz (
    id integer NOT NULL,
    name character varying,
    address character varying,
    summary integer,
    datecreate timestamp with time zone
);


ALTER TABLE public.zakaz OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 32918)
-- Name: zakaz_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.zakaz_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.zakaz_id_seq OWNER TO postgres;

--
-- TOC entry 2847 (class 0 OID 0)
-- Dependencies: 202
-- Name: zakaz_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.zakaz_id_seq OWNED BY public.zakaz.id;


--
-- TOC entry 2701 (class 2604 OID 32971)
-- Name: details id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.details ALTER COLUMN id SET DEFAULT nextval('public.details_id_seq'::regclass);


--
-- TOC entry 2700 (class 2604 OID 32923)
-- Name: zakaz id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zakaz ALTER COLUMN id SET DEFAULT nextval('public.zakaz_id_seq'::regclass);


--
-- TOC entry 2840 (class 0 OID 32968)
-- Dependencies: 206
-- Data for Name: details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.details (id, serialnumb, amount, id_zakaz) FROM stdin;
1	0258FACE	5	20
\.


--
-- TOC entry 2838 (class 0 OID 32953)
-- Dependencies: 204
-- Data for Name: specification; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.specification (serialnumb, name, specific, createdate) FROM stdin;
0255FACE	eToken	Safenet 5110	2018-11-14 00:00:00+00
0257FACE	ruToken	Aladdin	2018-07-15 08:31:12+00
0258FACE	ruToken	Aladdin	2018-07-15 08:31:12+00
\.


--
-- TOC entry 2837 (class 0 OID 32920)
-- Dependencies: 203
-- Data for Name: zakaz; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.zakaz (id, name, address, summary, datecreate) FROM stdin;
22	Сергей	Москва	14111	2020-11-23 11:42:42.573+00
20	Артур	Россия, Уфа	15111	2020-11-23 11:43:03.197+00
\.


--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 205
-- Name: details_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.details_id_seq', 1, false);


--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 202
-- Name: zakaz_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.zakaz_id_seq', 22, true);


--
-- TOC entry 2707 (class 2606 OID 32976)
-- Name: details details_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.details
    ADD CONSTRAINT details_pk PRIMARY KEY (id);


--
-- TOC entry 2705 (class 2606 OID 32960)
-- Name: specification specification_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.specification
    ADD CONSTRAINT specification_pk PRIMARY KEY (serialnumb);


--
-- TOC entry 2703 (class 2606 OID 32928)
-- Name: zakaz zakaz_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zakaz
    ADD CONSTRAINT zakaz_pk PRIMARY KEY (id);


--
-- TOC entry 2709 (class 2606 OID 33009)
-- Name: details details_specification_serialnumb_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.details
    ADD CONSTRAINT details_specification_serialnumb_fk FOREIGN KEY (serialnumb) REFERENCES public.specification(serialnumb) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2708 (class 2606 OID 33004)
-- Name: details details_zakaz_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.details
    ADD CONSTRAINT details_zakaz_id_fk FOREIGN KEY (id_zakaz) REFERENCES public.zakaz(id) ON UPDATE CASCADE ON DELETE CASCADE;


-- Completed on 2020-11-23 16:53:12

--
-- PostgreSQL database dump complete
--

