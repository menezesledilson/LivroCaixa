PGDMP     1    8                |            controlefinanceirotest    13.13    13.13     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24773    controlefinanceirotest    DATABASE     v   CREATE DATABASE controlefinanceirotest WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
 &   DROP DATABASE controlefinanceirotest;
                postgres    false            �            1259    24829    acesso    TABLE     �   CREATE TABLE public.acesso (
    id integer NOT NULL,
    usuario character varying(30),
    login character varying(30),
    senha character varying(4)
);
    DROP TABLE public.acesso;
       public         heap    postgres    false            �            1259    24827    acesso_id_seq    SEQUENCE     �   CREATE SEQUENCE public.acesso_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.acesso_id_seq;
       public          postgres    false    203            �           0    0    acesso_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.acesso_id_seq OWNED BY public.acesso.id;
          public          postgres    false    202            �            1259    24776 
   livrocaixa    TABLE     #  CREATE TABLE public.livrocaixa (
    id integer NOT NULL,
    datahora timestamp without time zone DEFAULT date_trunc('minute'::text, CURRENT_TIMESTAMP),
    descricao character varying(100),
    entrada double precision,
    saida double precision,
    observacao character varying(100)
);
    DROP TABLE public.livrocaixa;
       public         heap    postgres    false            �            1259    24774    livrocaixa_id_seq    SEQUENCE     �   CREATE SEQUENCE public.livrocaixa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.livrocaixa_id_seq;
       public          postgres    false    201            �           0    0    livrocaixa_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.livrocaixa_id_seq OWNED BY public.livrocaixa.id;
          public          postgres    false    200            *           2604    24832 	   acesso id    DEFAULT     f   ALTER TABLE ONLY public.acesso ALTER COLUMN id SET DEFAULT nextval('public.acesso_id_seq'::regclass);
 8   ALTER TABLE public.acesso ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202    203            (           2604    24779    livrocaixa id    DEFAULT     n   ALTER TABLE ONLY public.livrocaixa ALTER COLUMN id SET DEFAULT nextval('public.livrocaixa_id_seq'::regclass);
 <   ALTER TABLE public.livrocaixa ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    201    200    201            �          0    24829    acesso 
   TABLE DATA           ;   COPY public.acesso (id, usuario, login, senha) FROM stdin;
    public          postgres    false    203   �       �          0    24776 
   livrocaixa 
   TABLE DATA           Y   COPY public.livrocaixa (id, datahora, descricao, entrada, saida, observacao) FROM stdin;
    public          postgres    false    201          �           0    0    acesso_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.acesso_id_seq', 1, true);
          public          postgres    false    202            �           0    0    livrocaixa_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.livrocaixa_id_seq', 54, true);
          public          postgres    false    200            .           2606    24834    acesso acesso_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.acesso
    ADD CONSTRAINT acesso_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.acesso DROP CONSTRAINT acesso_pkey;
       public            postgres    false    203            ,           2606    24782    livrocaixa livrocaixa_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.livrocaixa
    ADD CONSTRAINT livrocaixa_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.livrocaixa DROP CONSTRAINT livrocaixa_pkey;
       public            postgres    false    201            �   #   x�3��IM��)���LL����44�4����� r      �   �   x�]�M� ���)�@���;/��m74��T1B���bBkb-�G���	Րh�0�NkGwϠ?�����C�֖'�jY.x��	�)�����qWq
�����eգ�_������O�p�tɼ�3UrM�����m�j'�jH��(*������я��*7?�[�~��9mA�     