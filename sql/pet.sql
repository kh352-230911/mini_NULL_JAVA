show user;
-- system으로 돌리고 하셈
--pet 생성
alter session set "_oracle_script"=true; -- c## 접두사 우회설정
create user pet -- 계정 pet
identified by pet -- 비번 pet
default tablespace users;

grant create session to pet; --create session 권한을 pet에게 부여
grant create table to pet; --table생성 권한
grant connect, resource to pet; -- 롤(권한 묶음)로써 부여해도 동일
alter user pet quota unlimited on users; --tablespace(실제데이터가 보관되는 장소) 사용용량 무제한으로 수정

select * from tb_member; -- 회원테이블
select * from tb_pet; -- 반려견테이블
select * from tb_restaurant; -- 맛집 테이블
select * from tb_hotel; -- 숙소테이블
select * from tb_tour; -- 관광지 테이블
select * from tb_cafe; -- 카페테이블

select
    *
from
    tb_member m join tb_pet p
        on m.id = p.member_id;
        
create table tb_member (
-- 컬럼레벨
    no number not null, -- 회원번호(pk)
    id varchar2(100) not null, -- 아이디(uq)
    password varchar2(100) not null, -- 비밀번호
    name varchar2(20) not null, -- 이름
    phone varchar2(20) not null, -- 폰번호
    address varchar2(200), -- 주소
    point number,
-- 테이블 레벨
    constraints pk_tb_member_no primary key(no),
    constraints uq_tb_member_id unique(id)
);

create sequence seq_tb_member_no;

delete from tb_member;
-- tb_member 테이블에 새로운 레코드 삽입
INSERT INTO tb_member VALUES (seq_tb_member_no.nextval, 'honggd', 'bye123', '홍길동', '010-1234-5678', '서울시 강남구 역삼동 3', 5000);
INSERT INTO tb_member VALUES (seq_tb_member_no.nextval, 'leess', 'ilovepet', '이순신', '010-2345-6789', '서울시 강남구 도곡동 21', 10000);
INSERT INTO tb_member VALUES (seq_tb_member_no.nextval, 'kimpet', 'petkim', '김철수', '010-3456-7890', '서울시 강북구 번1동 22', 25000);
INSERT INTO tb_member VALUES (seq_tb_member_no.nextval, 'qwerty', 'secret', '박영희', '010-4567-8901', '서울시 강남구 서초동 12', 30000);
INSERT INTO tb_member VALUES (seq_tb_member_no.nextval, 'cookie', 'amazing', '이미자', '010-5678-9012', '서울시 성북구 돈암동 2', 2000);
INSERT INTO tb_member VALUES (seq_tb_member_no.nextval, 'petpet', 'ptpt', '정수진', '010-6789-0123', '서울시 강북구 미아동 44', 5500);
INSERT INTO tb_member VALUES (seq_tb_member_no.nextval, 'petlove', 'yoohoo', '유영호', '010-7890-1234', '서울시 성북구 월곡동 33', 7000);
INSERT INTO tb_member VALUES (seq_tb_member_no.nextval, 'swings', 'porklove', '배민수', '010-8901-2345', '서울시 노원구 월계동 5', 50000);
INSERT INTO tb_member VALUES (seq_tb_member_no.nextval, 'jungho', 'hello94', '김지영', '010-9012-3456', '서울시 강남구 압구정동 512', 24000);
INSERT INTO tb_member VALUES (seq_tb_member_no.nextval, 'cholim', 'haha97', '이민우', '010-0123-4567', '서울시 송파구 잠실동 31', 1500);
INSERT INTO tb_member VALUES (seq_tb_member_no.nextval, 'bokyung', 'bk98', '박미경', '010-1234-5678', '서울시 강북구  수유동 23', 8000);
INSERT INTO tb_member VALUES (seq_tb_member_no.nextval, 'userpet', 'imimim', '정승민', '010-2345-6789', '서울시 강서구 염창동 3', 9000);
INSERT INTO tb_member VALUES (seq_tb_member_no.nextval, 'mangmang', 'hihihi', '신영희', '010-3456-7890', '서울시 강서구 염창동 98', 45000);
INSERT INTO tb_member VALUES (seq_tb_member_no.nextval, 'ksdjnk', 'fdsdzxd', '박영철', '010-4567-8901', '서울시 관악구 봉천동 29', 22000);
INSERT INTO tb_member VALUES (seq_tb_member_no.nextval, 'wrfeds', 'sdsdxfdc', '이미자', '010-5678-9012', '서울시 용산구 후암동 123', 10000);

create table tb_pet (
-- 컬럼레벨
    p_number number not null, -- 회원번호(pk)
    p_name varchar2(100) not null, -- 반려견이름
    member_id varchar2(100) not null, -- 견주 아이디(fk)
    p_type varchar2(100) not null, -- 품종
    Gender char(1) not null, -- 성별(ck)
    Weight number not null, -- 몸무게
    Birthday date default sysdate, -- 출생
-- order_date date default sysdate,
-- 테이블 레벨
    constraints pk_tb_pet_p_number primary key(p_number),
    constraints fk_tb_pet_member_id foreign key(member_id) references tb_member(id),
    constraints ck_tb_pet_gender check(gender in ('M', 'F'))
);

delete from tb_pet;
create sequence seq_tb_pet_no;

-- tb_pet 테이블에 새로운 레코드 삽입
INSERT INTO tb_pet VALUES (seq_tb_pet_no.nextval, '멍멍이', 'hello', '골든 리트리버', 'M', 15.5, TO_DATE('2020-05-15', 'YYYY-MM-DD'));
INSERT INTO tb_pet VALUES (seq_tb_pet_no.nextval, '뭉뭉이', 'ilovepet', '비숑 프리제', 'F', 6.2, TO_DATE('2019-11-10', 'YYYY-MM-DD'));
INSERT INTO tb_pet VALUES (seq_tb_pet_no.nextval, '먕먕이', 'kimpet', '시베리안 허스키', 'M', 18.3, TO_DATE('2018-03-25', 'YYYY-MM-DD'));
INSERT INTO tb_pet VALUES (seq_tb_pet_no.nextval, '널자바', 'qwerty', '푸들', 'F', 5.1, TO_DATE('2020-07-12', 'YYYY-MM-DD'));
INSERT INTO tb_pet VALUES (seq_tb_pet_no.nextval, '바자널', 'cookie', '보스턴 테리어', 'M', 8.7, TO_DATE('2019-05-18', 'YYYY-MM-DD'));
INSERT INTO tb_pet VALUES (seq_tb_pet_no.nextval, '뮹뮹이', 'petpet', '요크셔 테리어', 'F', 4.9, TO_DATE('2021-02-04', 'YYYY-MM-DD'));
INSERT INTO tb_pet VALUES (seq_tb_pet_no.nextval, '멍삼이', 'petlove', '레브라도 리트리버', 'M', 22.0, TO_DATE('2017-08-10', 'YYYY-MM-DD'));
INSERT INTO tb_pet VALUES (seq_tb_pet_no.nextval, '멍뭉이', 'swings', '치와와', 'F', 3.5, TO_DATE('2022-01-30', 'YYYY-MM-DD'));
INSERT INTO tb_pet VALUES (seq_tb_pet_no.nextval, '컹컹', 'jungho', '도베르만 핀셔', 'M', 32.1, TO_DATE('2016-11-22', 'YYYY-MM-DD'));
INSERT INTO tb_pet VALUES (seq_tb_pet_no.nextval, '빵빵이', 'cholim', '시추', 'F', 7.4, TO_DATE('2018-04-05', 'YYYY-MM-DD'));
INSERT INTO tb_pet VALUES (seq_tb_pet_no.nextval, '뱡뱡이', 'bokyung', '허스키', 'M', 20.8, TO_DATE('2017-12-15', 'YYYY-MM-DD'));
INSERT INTO tb_pet VALUES (seq_tb_pet_no.nextval, '뭉치', 'userpet', '퍼그', 'F', 6.8, TO_DATE('2019-09-08', 'YYYY-MM-DD'));
INSERT INTO tb_pet VALUES (seq_tb_pet_no.nextval, '형형', 'mangmang', '시바 이누', 'M', 12.2, TO_DATE('2020-03-01', 'YYYY-MM-DD'));
INSERT INTO tb_pet VALUES (seq_tb_pet_no.nextval, '먕뱡먕뱡', 'ksdjnk', '비글', 'F', 9.3, TO_DATE('2019-06-17', 'YYYY-MM-DD'));
INSERT INTO tb_pet VALUES (seq_tb_pet_no.nextval, '명명', 'wrfeds', '골든 레트리버', 'M', 21.5, TO_DATE('2017-05-20', 'YYYY-MM-DD'));

create table tb_restaurant (
-- 컬럼레벨
    restaurant_name varchar2(200) not null, -- 가게명
    openhours varchar2(20) not null, -- 영업시간
    parking char(1) not null, -- 주차여부(ck)
    address varchar2(200) not null, -- 주소
    restaurant_number varchar2(20) not null, -- 가게번호
    rating number not null, -- 맛집 평점
-- 테이블 레벨
    constraints ck_tb_restaurant_parking check(parking in ('Y', 'N'))
);

-- tb_restaurant 테이블에 새로운 레코드 삽입
INSERT INTO tb_restaurant VALUES('맛도리파스타', '09:00 - 20:00', 'Y', '서울시 강남구 신사동 44', '02-332-4455', 4.5);
INSERT INTO tb_restaurant VALUES ('dogcafe', '10:00 - 22:00', 'Y', '서울시 강남구 역삼동 234', '02-445-1111', 4.0);
INSERT INTO tb_restaurant VALUES('한솥집', '08:00 - 18:00', 'N', '서울시 강남구 대치동 58', '02-999-8888', 4.2);
INSERT INTO tb_restaurant VALUES ('냠냠파전', '11:30 - 21:30', 'Y', '서울시 종로구 익선동 67', '02-111-2222', 4.7);
INSERT INTO tb_restaurant VALUES ('흥부부대찌개', '10:00 - 20:00', 'Y', '서울시 용산구 이태원1동 33', '02-332-4675', 4.4);
INSERT INTO tb_restaurant VALUES ('밥스', '08:30 - 19:30', 'N', '서울시 마포구 신수동 61', '02-323-5392', 4.1);
INSERT INTO tb_restaurant VALUES ('킹크랩시장', '09:00 - 21:00', 'Y', '서울시 강남구 압구정동 1', '02-332-8754', 4.6);
INSERT INTO tb_restaurant VALUES ('미분당당당', '10:30 - 22:30', 'Y', '서울시 구로구 신도림동 5', '02-354-7823', 4.3);
INSERT INTO tb_restaurant VALUES ('순두부냠', '09:30 - 20:30', 'Y', '서울시 강북구 미아동 7', '02-843-3923', 4.9);
INSERT INTO tb_restaurant VALUES ('파더스터치', '08:00 - 21:00', 'N', '서울시 성북구 월곡동 5', '02-113-4422', 4.2);
INSERT INTO tb_restaurant VALUES ('미소야야', '11:00 - 22:00', 'Y', '서울시 성북구 장위동 55', '02-111-9999', 4.5);
INSERT INTO tb_restaurant VALUES ('집게리아', '10:00 - 20:00', 'Y', '서울시 강남구 역삼동 5', '02-333-4498', 4.8);
INSERT INTO tb_restaurant VALUES ('비키니시티', '08:30 - 19:30', 'N','서울시 노원구 월계동 4', '02-123-4598', 4.3);
INSERT INTO tb_restaurant VALUES ('정호네칼국수', '09:00 - 21:00', 'Y', '서울시 서대문구 충청로2가 1', '02-665-5555', 4.0);
INSERT INTO tb_restaurant VALUES ('초미파스타', '10:30 - 22:30', 'N', '서울시 용산구 이촌1동 77', '02-334-4444', 4.6);

create table tb_hotel (
-- 컬럼레벨
    hotel_name varchar2(200) not null, -- 숙소명
    parking char(1) not null, -- 주차여부(ck)
    address varchar2(200) not null, -- 주소
    hotel_number varchar2(20) not null, -- 숙소번호
    rating number not null, -- 숙소 평점
    check_in date default sysdate,
    check_out date default sysdate,
    rev_name,
    constraints ck_tb_hotel_parking check(parking in ('Y', 'N'))
);

-- tb_hotel 테이블에 새로운 레코드 삽입
INSERT INTO tb_hotel VALUES ('여기호텔', 'Y', '서울시 용산구 동자동 88', '02-111-2212', 4.5, default, default, default);
INSERT INTO tb_hotel VALUES ('서초하우스', 'N', '서울시 서초구 양재1동 7', '02-333-3332', 4.0, default, default, default);
INSERT INTO tb_hotel VALUES ('스위트홈', 'Y', '서울시 구로구 고척1동 10', '02-111-2345', 4.2, default, default, default);
INSERT INTO tb_hotel VALUES ('하하하숙소', 'N', '서울시 송파구 삼전동 55', '02-333-2222', 4.7, default, default, default);
INSERT INTO tb_hotel VALUES ('초코스테이', 'Y', '서울시 노원구 공릉2동 22', '02-987-6543', 4.4, default, default, default);
INSERT INTO tb_hotel VALUES ('안녕하소', 'N', '서울시 영등포구 당산동1가 51', '02-333-3333', 4.1, default, default, default);
INSERT INTO tb_hotel VALUES ('하하하여행스테이', 'Y', '서울시 강북구 우이동 25', '02-123-4444', 4.6, default, default, default);
INSERT INTO tb_hotel VALUES ('월화수목금토일', 'N', '서울시 구로구 항동 77', '02-444-3333', 4.3, default, default, default);
INSERT INTO tb_hotel VALUES ('해피하우스', 'Y', '서울시 강남구 자곡동 5', '02-432-1234', 4.9, default, default, default);
INSERT INTO tb_hotel VALUES ('하히호후히', 'N', '서울시 용산구 서빙고동 44', '02-333-2221', 4.2, default, default, default);
INSERT INTO tb_hotel VALUES ('신나스테이', 'Y', '서울시 종로구 이화동 28', '02-111-2224', 4.5, default, default, default);
INSERT INTO tb_hotel VALUES ('신난다숙소', 'N', '서울시 서초구 염곡동 55', '02-111-1111', 4.8, default, default, default);
INSERT INTO tb_hotel VALUES ('자바호텔', 'Y', '서울시 강북구 번2동 41', '02-115-5551', 4.3, default, default, default);
INSERT INTO tb_hotel VALUES ('sql호텔', 'N', '서울시 은평구 수색동 78', '02-555-5555', 4.0, default, default, default);
INSERT INTO tb_hotel VALUES ('jdbc스테이', 'Y', '서울시 강남구 서초동 33', '02-111-1154', 4.6, default, default, default);

create table tb_tour (
-- 컬럼레벨
    tour_name varchar2(200) not null, -- 관광지명
    parking char(1) not null, -- 주차여부(ck)
    address varchar2(200) not null, -- 주소
    tour_number varchar2(20) not null, -- 관광지번호
    rating number not null, -- 평점
    constraints ck_tb_tour_parking check(parking in ('Y', 'N'))
);

-- tb_tour 테이블에 새로운 레코드 삽입
INSERT INTO tb_tour VALUES ('롯두월드', 'Y', '서울시 송파구 장지동 42', '02-333-3337', 4.5);
INSERT INTO tb_tour VALUES ('정스아쿠아리움', 'N', '서울시 강남구 서초동 99', '02-111-1111', 4.0);
INSERT INTO tb_tour VALUES ('초임정원', 'Y', '서울시 용산구 한남동 91', '02-111-1114', 4.2);
INSERT INTO tb_tour VALUES ('보경책방', 'N', '서울시 강북구 인수동 177', '02-111-8374', 4.7);
INSERT INTO tb_tour VALUES ('무우진공원', 'Y', '서울시 서초구 반포2동 107', '02-333-2221', 4.4);
INSERT INTO tb_tour VALUES ('개트라이더', 'N', '서울시 은평구 녹번동 55', '02-333-3330', 4.1);
INSERT INTO tb_tour VALUES ('352빌딩', 'Y', '서울시 구로구 수궁동 76', '02-999-0000', 4.6);
INSERT INTO tb_tour VALUES ('자바월드', 'N', '서울시 노원구 상계5동 103', '02-111-1154', 4.3);
INSERT INTO tb_tour VALUES ('dog좋아', 'Y', '서울시 종로구 팔판동 98', '02-444-3456', 4.9);
INSERT INTO tb_tour VALUES ('서울아르피아', 'N', '서울시 서초구 내곡동 81' , '02-333-3338', 4.2);
INSERT INTO tb_tour VALUES ('남산서서울타워', 'Y', '서울시 용산구 이촌동 172', '02-333-4567', 4.5);
INSERT INTO tb_tour VALUES ('DDPPP', 'N', '서울시 동대문구 휘경2동 98', '02-126-6666', 4.8);
INSERT INTO tb_tour VALUES ('노원센트럴파크', 'Y', '서울시 노원구 중계본동 88', '02-111-1111', 4.3);
INSERT INTO tb_tour VALUES ('애바랜드', 'N', '서울시 종로구 낙원동 76', '02-555-6665', 4.0);
INSERT INTO tb_tour VALUES ('호호시장', 'Y', '서울시 강동구 암사동 34', '02-554-3234', 4.6);

create table tb_cafe (
-- 컬럼레벨
    cafe_name varchar2(200) not null, -- 카페명
    openhours varchar2(20) not null, -- 영업시간
    parking char(1) not null, -- 주차여부(ck)
    address varchar2(200) not null, -- 주소
    cafe_number varchar2(20) not null, -- 카페번호
    rating number not null, -- 평점
    constraints ck_tb_cafe_parking check(parking in ('Y', 'N'))
);

-- tb_cafe 테이블에 15개의 레코드 추가
INSERT INTO tb_cafe VALUES ('lovecafe', '09:00 - 20:00', 'Y', '서울시 강남구 서초동 232', '02-333-3344', 4.5);
INSERT INTO tb_cafe VALUES ('hellojava','10:00 - 23:00','N', '서울시 용산구 공덕동 103', '02-987-9834', 4.0);
INSERT INTO tb_cafe VALUES ('cakeyamyam', '09:00 - 23:00', 'Y', '서울시 서초구 신원동 88', '02-247-4383', 4.2);
INSERT INTO tb_cafe VALUES ('dogbookcafe', '11:00 - 21:00','N', '서울시 구로구 수궁동 51', '02-328-3222', 4.7);
INSERT INTO tb_cafe VALUES ('pingpong', '09:00 - 20:00', 'Y', '서울시 노원구 상계4동 88', '02-323-2397', 4.4);
INSERT INTO tb_cafe VALUES ('puddingcafe', '12:00 - 20:00', 'N', '서울시 송파구 장지동 55', '02-348-3872', 4.1);
INSERT INTO tb_cafe VALUES ('맥이브닝', '10:00 - 22:00', 'Y', '서울시 중구 장충동1가 109', '02-823-8233', 4.6);
INSERT INTO tb_cafe VALUES ('탐앤스탐', '09:00 - 20:00', 'N', '서울시 동대문구 장안1동 99', '02-321-3423', 4.3);
INSERT INTO tb_cafe VALUES ('스타잡스', '11:00 - 20:00', 'Y', '서울시 서대문구 천연동 99', '02-329-9863', 4.9);
INSERT INTO tb_cafe VALUES ('메기커피', '07:00 - 22:00', 'N', '서울시 용산구 후암동 33', '02-389-9843', 4.2);
INSERT INTO tb_cafe VALUES ('null카페', '09:00 - 22:00', 'Y', '서울시 강북구 송천동 44', '02-899-9999', 4.5);
INSERT INTO tb_cafe VALUES ('chococafe', '12:00 - 22:00', 'N', '서울시 서초구 내곡동 92', '02-389-9876', 4.8);
INSERT INTO tb_cafe VALUES ('야미버블티', '08:00 - 22:00', 'Y', '서울시 은평구 응암동 99', '02-321-5893', 4.3);
INSERT INTO tb_cafe VALUES ('라이언카페', '07:00 - 23:00', 'N', '서울시 마포구 신공덕동 211', '02-382-9843', 4.0);
INSERT INTO tb_cafe VALUES ('얌야미미미케이크', '14:00 - 22:00','Y', '서울시 중구 쌍림동 77', '02-392-9324', 4.6);

select * from reservation_hotel;
delete from reservation_hotel;
commit;

select 
    *
from 
    tb_member m join tb_pet p
        on m.id = p.member_id
where 
    m.address like '%강남구%';

create table reservation_hotel
as
select hotel_name, address, hotel_number, check_in, check_out, rev_name
from tb_hotel;


create or replace trigger trig_reservation_hotel
    after
    insert or update or delete on tb_hotel
    for each row
begin
    if updating then
        insert into
            reservation_hotel(hotel_name, address, hotel_number, check_in, check_out, rev_name)
        values(:old.hotel_name, :old.address, :old.hotel_number, :new.check_in, :new.check_out, :new.rev_name);      
    end if;
end;
/

commit;


create table tb_shopping(
    name varchar2(50) not null,
    price number not null
);

select * from  shopping_list;
select * from  tb_shopping;

--drop table tb_shopping;
--delete from shopping_list;

create table shopping_list
as
select * from tb_shopping
where 1 = 2;

select * from shopping_list;
select * from tb_shopping;

create or replace trigger trig_shopping_list
    after
    update on tb_shopping
    for each row
begin
    if updating then
        insert into
            shopping_list(name, price)
        values(:old.name, :old.price);
    end if;
end;
/

INSERT INTO tb_shopping VALUES ('유기농 사료 4kg', 5000);
INSERT INTO tb_shopping VALUES ('배변 패드 30매', 3000);
INSERT INTO tb_shopping VALUES ('애견 장난감', 1000);
INSERT INTO tb_shopping VALUES ('애견 옷', 3000);
INSERT INTO tb_shopping VALUES ('리드줄(목줄)', 2000);
INSERT INTO tb_shopping VALUES ('애견 치약/칫솔', 2000);
INSERT INTO tb_shopping VALUES ('애견 샴푸' , 2500);
INSERT INTO tb_shopping VALUES ('애견 간식(껌)' , 500);
INSERT INTO tb_shopping VALUES ('애견 브러쉬' , 1000);
INSERT INTO tb_shopping VALUES ('애견 베드 쿠션' ,7000);
INSERT INTO tb_shopping VALUES ('애견 발톱깎기', 2000);
INSERT INTO tb_shopping VALUES ('케이지' , 6000);
INSERT INTO tb_shopping VALUES('급수기', 4000);
INSERT INTO tb_shopping VALUES('애견신발', 3500);