

SET search_path = public;

--
-- TOC entry 197 (class 1259 OID 16532)
-- Name: class_parameters; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE class_parameters (
    id integer NOT NULL,
    description character varying(50)
);


ALTER TABLE class_parameters OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16530)
-- Name: class_parameters_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE class_parameters_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE class_parameters_id_seq OWNER TO postgres;

--
-- TOC entry 2813 (class 0 OID 0)
-- Dependencies: 196
-- Name: class_parameters_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE class_parameters_id_seq OWNED BY class_parameters.id;


--
-- TOC entry 198 (class 1259 OID 24717)
-- Name: parameters; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE parameters (
    id integer NOT NULL,
    description character varying(200) NOT NULL,
    class_parameters_id integer NOT NULL
);


ALTER TABLE parameters OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 24720)
-- Name: parameters_parameters_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE parameters_parameters_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE parameters_parameters_id_seq OWNER TO postgres;

--
-- TOC entry 2814 (class 0 OID 0)
-- Dependencies: 199
-- Name: parameters_parameters_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE parameters_parameters_id_seq OWNED BY parameters.id;


--
-- TOC entry 2676 (class 2604 OID 16535)
-- Name: class_parameters id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY class_parameters ALTER COLUMN id SET DEFAULT nextval('class_parameters_id_seq'::regclass);


--
-- TOC entry 2677 (class 2604 OID 24722)
-- Name: parameters id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parameters ALTER COLUMN id SET DEFAULT nextval('parameters_parameters_id_seq'::regclass);


--
-- TOC entry 2805 (class 0 OID 16532)
-- Dependencies: 197
-- Data for Name: class_parameters; Type: TABLE DATA; Schema: public; Owner: postgres
--


ALTER TABLE ONLY class_parameters
    ADD CONSTRAINT "PK_CLASS_PARAMETERS_ID" PRIMARY KEY (id);


--
-- TOC entry 2681 (class 2606 OID 24729)
-- Name: parameters PK_parameters_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parameters
    ADD CONSTRAINT "PK_parameters_id" PRIMARY KEY (id);


--
-- TOC entry 2682 (class 2606 OID 24723)
-- Name: parameters FK_parameter_class_parameters_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parameters
    ADD CONSTRAINT "FK_parameter_class_parameters_id" FOREIGN KEY (class_parameters_id) REFERENCES class_parameters(id);


-- Completed on 2017-11-12 19:17:17

--
-- PostgreSQL database dump complete
--

