-- 버전3-4
-- ddl, 고정데이터 insert

-- 광역시도
DROP TABLE IF EXISTS `har_sido` RESTRICT;

-- 글
DROP TABLE IF EXISTS `har_post` RESTRICT;

-- 대댓글
DROP TABLE IF EXISTS `har_recomment` RESTRICT;

-- 대댓글좋아요
DROP TABLE IF EXISTS `har_recom_like` RESTRICT;

-- 대분류
DROP TABLE IF EXISTS `har_broad_cat` RESTRICT;

-- 댓글
DROP TABLE IF EXISTS `har_comment` RESTRICT;

-- 댓글좋아요
DROP TABLE IF EXISTS `har_com_like` RESTRICT;

-- 상품구매
DROP TABLE IF EXISTS `har_purchase` RESTRICT;

-- 상품구매후기
DROP TABLE IF EXISTS `har_prrv` RESTRICT;

-- 상품장바구니
DROP TABLE IF EXISTS `har_pr_cart` RESTRICT;

-- 서비스기본정보
DROP TABLE IF EXISTS `har_service` RESTRICT;

-- 서비스문의글
DROP TABLE IF EXISTS `har_sqna` RESTRICT;

-- 서비스문의답글파일
DROP TABLE IF EXISTS `har_srpl_file` RESTRICT;

-- 소분류
DROP TABLE IF EXISTS `har_narrow_cat` RESTRICT;

-- 수업일정
DROP TABLE IF EXISTS `har_schedule` RESTRICT;

-- 스토리게시판
DROP TABLE IF EXISTS `har_feed` RESTRICT;

-- 스토리좋아요
DROP TABLE IF EXISTS `har_feed_like` RESTRICT;

-- 시군구
DROP TABLE IF EXISTS `har_sigungu` RESTRICT;

-- 위시리스트
DROP TABLE IF EXISTS `har_wishlist` RESTRICT;

-- 체험장바구니
DROP TABLE IF EXISTS `har_lrn_cart` RESTRICT;

-- 체험학습
DROP TABLE IF EXISTS `har_learning` RESTRICT;

-- 체험학습신청
DROP TABLE IF EXISTS `har_lrn_appl` RESTRICT;

-- 체험학습후기
DROP TABLE IF EXISTS `har_lrnrv` RESTRICT;

-- 체험후기추천수
DROP TABLE IF EXISTS `har_lrnrv_rcm` RESTRICT;

-- 튜터
DROP TABLE IF EXISTS `har_tutor` RESTRICT;

-- 튜터문의게시판
DROP TABLE IF EXISTS `har_tqna` RESTRICT;

-- 튜터문의답글파일
DROP TABLE IF EXISTS `har_trpl_file` RESTRICT;

-- 튜터지역
DROP TABLE IF EXISTS `har_tdist` RESTRICT;

-- 튜터카테고리
DROP TABLE IF EXISTS `har_tcat` RESTRICT;

-- 파일
DROP TABLE IF EXISTS `har_file` RESTRICT;

-- 판매상품
DROP TABLE IF EXISTS `har_product` RESTRICT;

-- 판매상품사진
DROP TABLE IF EXISTS `har_prpic` RESTRICT;

-- 판매상품옵션
DROP TABLE IF EXISTS `har_pr_opt` RESTRICT;

-- 판매상품후기추천수
DROP TABLE IF EXISTS `har_prrv_rcm` RESTRICT;

-- 팔로우
DROP TABLE IF EXISTS `har_follow` RESTRICT;

-- 회원
DROP TABLE IF EXISTS `har_member` RESTRICT;

-- 회원등급
DROP TABLE IF EXISTS `har_mrank` RESTRICT;

-- 광역시도
CREATE TABLE `har_sido` (
	`sido_no`   INTEGER     NOT NULL COMMENT '광역시도번호', -- 광역시도번호
	`sido_name` VARCHAR(50) NOT NULL COMMENT '시도명' -- 시도명
)
COMMENT '광역시도';

-- 광역시도
ALTER TABLE `har_sido`
	ADD CONSTRAINT `PK_har_sido` -- 광역시도 기본키
		PRIMARY KEY (
			`sido_no` -- 광역시도번호
		);

-- 광역시도 유니크 인덱스
CREATE UNIQUE INDEX `UIX_har_sido`
	ON `har_sido` ( -- 광역시도
		`sido_name` ASC -- 시도명
	);

ALTER TABLE `har_sido`
	MODIFY COLUMN `sido_no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '광역시도번호';

-- 글
CREATE TABLE `har_post` (
	`pno`      INTEGER  NOT NULL COMMENT '글번호', -- 글번호
	`content`  LONGTEXT NOT NULL COMMENT '내용', -- 내용
	`wdttm`    DATETIME NOT NULL DEFAULT now() COMMENT '작성일시', -- 작성일시
	`view_cnt` INTEGER  NOT NULL DEFAULT 0 COMMENT '조회수', -- 조회수
	`pstat`    INTEGER  NOT NULL DEFAULT 1 COMMENT '글상태' -- 글상태
)
COMMENT '글';

-- 글
ALTER TABLE `har_post`
	ADD CONSTRAINT `PK_har_post` -- 글 기본키
		PRIMARY KEY (
			`pno` -- 글번호
		);

-- 글
ALTER TABLE `har_post`
	ADD CONSTRAINT `CK_har_post` -- 글 체크 제약
		CHECK (pstat = 0 or pstat = 1);

ALTER TABLE `har_post`
	MODIFY COLUMN `pno` INTEGER NOT NULL AUTO_INCREMENT COMMENT '글번호';

-- 대댓글
CREATE TABLE `har_recomment` (
	`recom_no`   INTEGER  NOT NULL COMMENT '대댓글번호', -- 대댓글번호
	`com_no`     INTEGER  NOT NULL COMMENT '댓글번호', -- 댓글번호
	`mno`        INTEGER  NOT NULL COMMENT '대댓글작성자번호', -- 대댓글작성자번호
	`content`    LONGTEXT NOT NULL COMMENT '내용', -- 내용
	`rdttm`      DATETIME NOT NULL DEFAULT now() COMMENT '등록일시', -- 등록일시
	`recom_stat` INTEGER  NOT NULL DEFAULT 1 COMMENT '대댓글상태', -- 대댓글상태
	`tagged_mem` INTEGER  NOT NULL COMMENT '태그된 회원' -- 태그된 회원
)
COMMENT '대댓글';

-- 대댓글
ALTER TABLE `har_recomment`
	ADD CONSTRAINT `PK_har_recomment` -- 대댓글 기본키
		PRIMARY KEY (
			`recom_no` -- 대댓글번호
		);

-- 대댓글
ALTER TABLE `har_recomment`
	ADD CONSTRAINT `CK_har_recomment` -- 대댓글 체크 제약
		CHECK (recom_stat = 0 or recom_stat = 1);

ALTER TABLE `har_recomment`
	MODIFY COLUMN `recom_no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '대댓글번호';

-- 대댓글좋아요
CREATE TABLE `har_recom_like` (
	`recom_no` INTEGER NOT NULL COMMENT '대댓글번호', -- 대댓글번호
	`mno`      INTEGER NOT NULL COMMENT '회원번호' -- 회원번호
)
COMMENT '대댓글좋아요';

-- 대댓글좋아요
ALTER TABLE `har_recom_like`
	ADD CONSTRAINT `PK_har_recom_like` -- 대댓글좋아요 기본키
		PRIMARY KEY (
			`recom_no`, -- 대댓글번호
			`mno`       -- 회원번호
		);

-- 대분류
CREATE TABLE `har_broad_cat` (
	`bcat_no`   INTEGER     NOT NULL COMMENT '대분류번호', -- 대분류번호
	`bcat_name` VARCHAR(50) NOT NULL COMMENT '대분류명' -- 대분류명
)
COMMENT '대분류';

-- 대분류
ALTER TABLE `har_broad_cat`
	ADD CONSTRAINT `PK_har_broad_cat` -- 대분류 기본키
		PRIMARY KEY (
			`bcat_no` -- 대분류번호
		);

-- 대분류 유니크 인덱스
CREATE UNIQUE INDEX `UIX_har_broad_cat`
	ON `har_broad_cat` ( -- 대분류
		`bcat_name` ASC -- 대분류명
	);

ALTER TABLE `har_broad_cat`
	MODIFY COLUMN `bcat_no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '대분류번호';

-- 댓글
CREATE TABLE `har_comment` (
	`com_no`   INTEGER  NOT NULL COMMENT '댓글번호', -- 댓글번호
	`feed_no`  INTEGER  NOT NULL COMMENT '글번호', -- 글번호
	`mno`      INTEGER  NOT NULL COMMENT '댓글작성자번호', -- 댓글작성자번호
	`comment`  LONGTEXT NOT NULL COMMENT '내용', -- 내용
	`com_stat` INTEGER  NOT NULL DEFAULT 1 COMMENT '댓글상태', -- 댓글상태
	`com_dttm` DATETIME NULL     DEFAULT now() COMMENT '등록일시' -- 등록일시
)
COMMENT '댓글';

-- 댓글
ALTER TABLE `har_comment`
	ADD CONSTRAINT `PK_har_comment` -- 댓글 기본키
		PRIMARY KEY (
			`com_no` -- 댓글번호
		);

-- 댓글
ALTER TABLE `har_comment`
	ADD CONSTRAINT `CK_har_comment` -- 댓글 체크 제약
		CHECK (com_stat = 0 or com_stat = 1);

ALTER TABLE `har_comment`
	MODIFY COLUMN `com_no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '댓글번호';

-- 댓글좋아요
CREATE TABLE `har_com_like` (
	`com_no` INTEGER NOT NULL COMMENT '댓글번호', -- 댓글번호
	`mno`    INTEGER NOT NULL COMMENT '회원번호' -- 회원번호
)
COMMENT '댓글좋아요';

-- 댓글좋아요
ALTER TABLE `har_com_like`
	ADD CONSTRAINT `PK_har_com_like` -- 댓글좋아요 기본키
		PRIMARY KEY (
			`com_no`, -- 댓글번호
			`mno`     -- 회원번호
		);

-- 상품구매
CREATE TABLE `har_purchase` (
	`purc_no`    INTEGER     NOT NULL COMMENT '상품옵션구매번호', -- 상품옵션구매번호
	`mno`        INTEGER     NOT NULL COMMENT '구매회원번호', -- 구매회원번호
	`opt_no`     INTEGER     NOT NULL COMMENT '상품옵션번호', -- 상품옵션번호
	`prdttm`     DATETIME    NOT NULL DEFAULT now() COMMENT '구매일시', -- 구매일시
	`prsize`     INTEGER     NOT NULL DEFAULT 1 COMMENT '구매수량', -- 구매수량
	`invoice_no` VARCHAR(30) NOT NULL COMMENT '송장번호', -- 송장번호
	`deli_comp`  INTEGER     NOT NULL DEFAULT 0 COMMENT '배송완료' -- 배송완료
)
COMMENT '상품구매';

-- 상품구매
ALTER TABLE `har_purchase`
	ADD CONSTRAINT `PK_har_purchase` -- 상품구매 기본키
		PRIMARY KEY (
			`purc_no` -- 상품옵션구매번호
		);

-- 상품구매
ALTER TABLE `har_purchase`
	ADD CONSTRAINT `CK_har_purchase` -- 상품구매 체크 제약
		CHECK (deli_comp = 0 or deli_comp = 1);

-- 상품구매 유니크 인덱스
CREATE UNIQUE INDEX `UIX_har_purchase`
	ON `har_purchase` ( -- 상품구매
		`invoice_no` ASC -- 송장번호
	);

ALTER TABLE `har_purchase`
	MODIFY COLUMN `purc_no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '상품옵션구매번호';

-- 상품구매후기
CREATE TABLE `har_prrv` (
	`pno`     INTEGER      NOT NULL COMMENT '글번호', -- 글번호
	`purc_no` INTEGER      NOT NULL COMMENT '상품옵션구매번호', -- 상품옵션구매번호
	`title`   VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	`rate`    DOUBLE       NOT NULL DEFAULT 1 COMMENT '평점' -- 평점
)
COMMENT '상품구매후기';

-- 상품구매후기
ALTER TABLE `har_prrv`
	ADD CONSTRAINT `PK_har_prrv` -- 상품구매후기 기본키
		PRIMARY KEY (
			`pno` -- 글번호
		);

-- 상품구매후기
ALTER TABLE `har_prrv`
	ADD CONSTRAINT `CK_har_prrv` -- 상품구매후기 체크 제약
		CHECK (rate >= 1 and rate <= 5 and (rate*10)%5=0);

-- 상품구매후기 유니크 인덱스
CREATE UNIQUE INDEX `UIX_har_prrv`
	ON `har_prrv` ( -- 상품구매후기
		`purc_no` ASC -- 상품옵션구매번호
	);

-- 상품장바구니
CREATE TABLE `har_pr_cart` (
	`mno`    INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	`opt_no` INTEGER NOT NULL COMMENT '상품옵션번호', -- 상품옵션번호
	`prsize` INTEGER NOT NULL DEFAULT 1 COMMENT '개수', -- 개수
	`price`  INTEGER NOT NULL COMMENT '가격' -- 가격
)
COMMENT '상품장바구니';

-- 상품장바구니
ALTER TABLE `har_pr_cart`
	ADD CONSTRAINT `PK_har_pr_cart` -- 상품장바구니 기본키
		PRIMARY KEY (
			`mno`,    -- 회원번호
			`opt_no`  -- 상품옵션번호
		);

-- 서비스기본정보
CREATE TABLE `har_service` (
	`sno`     INTEGER      NOT NULL COMMENT '서비스번호', -- 서비스번호
	`sname`   VARCHAR(50)  NOT NULL COMMENT '서비스이름', -- 서비스이름
	`sintro`  LONGTEXT     NOT NULL COMMENT '서비스소개', -- 서비스소개
	`cov_img` VARCHAR(255) NOT NULL COMMENT '커버이미지', -- 커버이미지
	`sstat`   INTEGER      NOT NULL DEFAULT 1 COMMENT '서비스상태', -- 서비스상태
	`rdttm`   DATETIME     NOT NULL DEFAULT now() COMMENT '등록일시', -- 등록일시
	`ncat_no` INTEGER      NOT NULL COMMENT '소분류번호' -- 소분류번호
)
COMMENT '서비스기본정보';

-- 서비스기본정보
ALTER TABLE `har_service`
	ADD CONSTRAINT `PK_har_service` -- 서비스기본정보 기본키
		PRIMARY KEY (
			`sno` -- 서비스번호
		);

-- 서비스기본정보
ALTER TABLE `har_service`
	ADD CONSTRAINT `CK_har_service` -- 서비스기본정보 체크 제약
		CHECK (sstat = 0 or sstat = 1);

ALTER TABLE `har_service`
	MODIFY COLUMN `sno` INTEGER NOT NULL AUTO_INCREMENT COMMENT '서비스번호';

-- 서비스문의글
CREATE TABLE `har_sqna` (
	`pno`         INTEGER      NOT NULL COMMENT '글번호', -- 글번호
	`mno`         INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	`sno`         INTEGER      NOT NULL COMMENT '서비스번호', -- 서비스번호
	`title`       VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	`secret`      INTEGER      NOT NULL DEFAULT 1 COMMENT '비밀글여부', -- 비밀글여부
	`rpl_content` LONGTEXT     NULL     COMMENT '답변내용', -- 답변내용
	`rpl_dttm`    DATETIME     NULL     COMMENT '답변일시' -- 답변일시
)
COMMENT '서비스문의글';

-- 서비스문의글
ALTER TABLE `har_sqna`
	ADD CONSTRAINT `PK_har_sqna` -- 서비스문의글 기본키
		PRIMARY KEY (
			`pno` -- 글번호
		);

-- 서비스문의글
ALTER TABLE `har_sqna`
	ADD CONSTRAINT `CK_har_sqna` -- 서비스문의글 체크 제약
		CHECK (secret = 0 or secret = 1);

-- 서비스문의답글파일
CREATE TABLE `har_srpl_file` (
	`srpl_fno`   INTEGER      NOT NULL COMMENT '파일번호', -- 파일번호
	`srpl_fname` VARCHAR(255) NOT NULL COMMENT '파일명', -- 파일명
	`pno`        INTEGER      NOT NULL COMMENT '글번호' -- 글번호
)
COMMENT '서비스문의답글파일';

-- 서비스문의답글파일
ALTER TABLE `har_srpl_file`
	ADD CONSTRAINT `PK_har_srpl_file` -- 서비스문의답글파일 기본키
		PRIMARY KEY (
			`srpl_fno` -- 파일번호
		);

ALTER TABLE `har_srpl_file`
	MODIFY COLUMN `srpl_fno` INTEGER NOT NULL AUTO_INCREMENT COMMENT '파일번호';

-- 소분류
CREATE TABLE `har_narrow_cat` (
	`ncat_no`   INTEGER     NOT NULL COMMENT '소분류번호', -- 소분류번호
	`ncat_name` VARCHAR(50) NOT NULL COMMENT '소분류명', -- 소분류명
	`bcat_no`   INTEGER     NOT NULL COMMENT '대분류번호' -- 대분류번호
)
COMMENT '소분류';

-- 소분류
ALTER TABLE `har_narrow_cat`
	ADD CONSTRAINT `PK_har_narrow_cat` -- 소분류 기본키
		PRIMARY KEY (
			`ncat_no` -- 소분류번호
		);

ALTER TABLE `har_narrow_cat`
	MODIFY COLUMN `ncat_no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '소분류번호';

-- 수업일정
CREATE TABLE `har_schedule` (
	`sche_no` INTEGER NOT NULL COMMENT '수업일정번호', -- 수업일정번호
	`lno`     INTEGER NOT NULL COMMENT '체험학습번호', -- 체험학습번호
	`date`    DATE    NOT NULL COMMENT '날짜', -- 날짜
	`stm`     TIME    NOT NULL COMMENT '시작시각', -- 시작시각
	`etm`     TIME    NOT NULL COMMENT '종료시각' -- 종료시각
)
COMMENT '수업일정';

-- 수업일정
ALTER TABLE `har_schedule`
	ADD CONSTRAINT `PK_har_schedule` -- 수업일정 기본키
		PRIMARY KEY (
			`sche_no` -- 수업일정번호
		);

-- 수업일정 유니크 인덱스
CREATE UNIQUE INDEX `UIX_har_schedule`
	ON `har_schedule` ( -- 수업일정
		`lno` ASC,  -- 체험학습번호
		`stm` ASC,  -- 시작시각
		`etm` ASC,  -- 종료시각
		`date` ASC  -- 날짜
	);

ALTER TABLE `har_schedule`
	MODIFY COLUMN `sche_no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '수업일정번호';

-- 스토리게시판
CREATE TABLE `har_feed` (
	`feed_no` INTEGER NOT NULL COMMENT '글번호', -- 글번호
	`tno`     INTEGER NOT NULL COMMENT '튜터번호' -- 튜터번호
)
COMMENT '스토리게시판';

-- 스토리게시판
ALTER TABLE `har_feed`
	ADD CONSTRAINT `PK_har_feed` -- 스토리게시판 기본키
		PRIMARY KEY (
			`feed_no` -- 글번호
		);

-- 스토리좋아요
CREATE TABLE `har_feed_like` (
	`feed_no` INTEGER NOT NULL COMMENT '글번호', -- 글번호
	`mno`     INTEGER NOT NULL COMMENT '회원번호' -- 회원번호
)
COMMENT '스토리좋아요';

-- 스토리좋아요
ALTER TABLE `har_feed_like`
	ADD CONSTRAINT `PK_har_feed_like` -- 스토리좋아요 기본키
		PRIMARY KEY (
			`feed_no`, -- 글번호
			`mno`      -- 회원번호
		);

-- 시군구
CREATE TABLE `har_sigungu` (
	`sgg_no`   INTEGER     NOT NULL COMMENT '시군구번호', -- 시군구번호
	`sido_no`  INTEGER     NOT NULL COMMENT '광역시도번호', -- 광역시도번호
	`sgg_name` VARCHAR(50) NOT NULL COMMENT '시군구명' -- 시군구명
)
COMMENT '시군구';

-- 시군구
ALTER TABLE `har_sigungu`
	ADD CONSTRAINT `PK_har_sigungu` -- 시군구 기본키
		PRIMARY KEY (
			`sgg_no` -- 시군구번호
		);

ALTER TABLE `har_sigungu`
	MODIFY COLUMN `sgg_no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '시군구번호';

-- 위시리스트
CREATE TABLE `har_wishlist` (
	`mno` INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	`sno` INTEGER NOT NULL COMMENT '서비스번호' -- 서비스번호
)
COMMENT '위시리스트';

-- 위시리스트
ALTER TABLE `har_wishlist`
	ADD CONSTRAINT `PK_har_wishlist` -- 위시리스트 기본키
		PRIMARY KEY (
			`mno`, -- 회원번호
			`sno`  -- 서비스번호
		);

-- 체험장바구니
CREATE TABLE `har_lrn_cart` (
	`mno`       INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	`sche_no`   INTEGER NOT NULL COMMENT '수업일정번호', -- 수업일정번호
	`appl_size` INTEGER NOT NULL DEFAULT 1 COMMENT '인원수', -- 인원수
	`price`     INTEGER NOT NULL COMMENT '가격' -- 가격
)
COMMENT '체험장바구니';

-- 체험장바구니
ALTER TABLE `har_lrn_cart`
	ADD CONSTRAINT `PK_har_lrn_cart` -- 체험장바구니 기본키
		PRIMARY KEY (
			`mno`,     -- 회원번호
			`sche_no`  -- 수업일정번호
		);

-- 체험학습
CREATE TABLE `har_learning` (
	`lno`        INTEGER      NOT NULL COMMENT '체험학습번호', -- 체험학습번호
	`sgg_no`     INTEGER      NOT NULL COMMENT '시군구번호', -- 시군구번호
	`min_head`   INTEGER      NOT NULL DEFAULT 1 COMMENT '최소 인원수', -- 최소 인원수
	`max_head`   INTEGER      NOT NULL DEFAULT min_head COMMENT '최대 인원수', -- 최대 인원수
	`curriculum` LONGTEXT     NOT NULL COMMENT '진행 순서', -- 진행 순서
	`price`      INTEGER      NOT NULL COMMENT '가격', -- 가격
	`zipcode`    VARCHAR(7)   NOT NULL COMMENT '우편번호', -- 우편번호
	`addr`       VARCHAR(255) NOT NULL COMMENT '기본주소', -- 기본주소
	`det_addr`   VARCHAR(255) NULL     COMMENT '상세주소', -- 상세주소
	`tno`        INTEGER      NOT NULL COMMENT '튜터번호', -- 튜터번호
	`rfnd_info`  LONGTEXT     NOT NULL COMMENT '환불정보' -- 환불정보
)
COMMENT '체험학습';

-- 체험학습
ALTER TABLE `har_learning`
	ADD CONSTRAINT `PK_har_learning` -- 체험학습 기본키
		PRIMARY KEY (
			`lno` -- 체험학습번호
		);

-- 체험학습
ALTER TABLE `har_learning`
	ADD CONSTRAINT `CK_har_learning` -- 체험학습 체크 제약
		CHECK (min_head >= 1);

-- 체험학습
ALTER TABLE `har_learning`
	ADD CONSTRAINT `CK_har_learning2` -- 체험학습 체크 제약2
		CHECK (max_head >= min_head);

-- 체험학습
ALTER TABLE `har_learning`
	ADD CONSTRAINT `CK_har_learning3` -- 체험학습 체크 제약3
		CHECK (price % 1000 = 0);

-- 체험학습신청
CREATE TABLE `har_lrn_appl` (
	`lrn_appl_no` INTEGER  NOT NULL COMMENT '체험학습신청번호', -- 체험학습신청번호
	`mno`         INTEGER  NOT NULL COMMENT '신청회원번호', -- 신청회원번호
	`sche_no`     INTEGER  NOT NULL COMMENT '수업일정번호', -- 수업일정번호
	`appl_size`   INTEGER  NOT NULL DEFAULT 1 COMMENT '신청수량', -- 신청수량
	`appl_dttm`   DATETIME NOT NULL DEFAULT now() COMMENT '신청일시' -- 신청일시
)
COMMENT '체험학습신청';

-- 체험학습신청
ALTER TABLE `har_lrn_appl`
	ADD CONSTRAINT `PK_har_lrn_appl` -- 체험학습신청 기본키
		PRIMARY KEY (
			`lrn_appl_no` -- 체험학습신청번호
		);

ALTER TABLE `har_lrn_appl`
	MODIFY COLUMN `lrn_appl_no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '체험학습신청번호';

-- 체험학습후기
CREATE TABLE `har_lrnrv` (
	`pno`         INTEGER      NOT NULL COMMENT '글번호', -- 글번호
	`lrn_appl_no` INTEGER      NOT NULL COMMENT '체험학습신청번호', -- 체험학습신청번호
	`title`       VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	`rate`        DOUBLE       NOT NULL DEFAULT 1 COMMENT '평점' -- 평점
)
COMMENT '체험학습후기';

-- 체험학습후기
ALTER TABLE `har_lrnrv`
	ADD CONSTRAINT `PK_har_lrnrv` -- 체험학습후기 기본키
		PRIMARY KEY (
			`pno` -- 글번호
		);

-- 체험학습후기
ALTER TABLE `har_lrnrv`
	ADD CONSTRAINT `CK_har_lrnrv` -- 체험학습후기 체크 제약
		CHECK (rate >= 1 and rate <= 5 and (rate*10)%5=0);

-- 체험학습후기 유니크 인덱스
CREATE UNIQUE INDEX `UIX_har_lrnrv`
	ON `har_lrnrv` ( -- 체험학습후기
		`lrn_appl_no` ASC -- 체험학습신청번호
	);

-- 체험후기추천수
CREATE TABLE `har_lrnrv_rcm` (
	`mno` INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	`pno` INTEGER NOT NULL COMMENT '글번호' -- 글번호
)
COMMENT '체험후기추천수';

-- 체험후기추천수
ALTER TABLE `har_lrnrv_rcm`
	ADD CONSTRAINT `PK_har_lrnrv_rcm` -- 체험후기추천수 기본키
		PRIMARY KEY (
			`mno`, -- 회원번호
			`pno`  -- 글번호
		);

-- 튜터
CREATE TABLE `har_tutor` (
	`tno`       INTEGER      NOT NULL COMMENT '튜터번호', -- 튜터번호
	`tintro`    LONGTEXT     NOT NULL COMMENT '튜터소개', -- 튜터소개
	`tappl`     VARCHAR(255) NOT NULL COMMENT '튜터신청서', -- 튜터신청서
	`prom_dttm` DATETIME     NOT NULL DEFAULT now() COMMENT '등업일시' -- 등업일시
)
COMMENT '튜터';

-- 튜터
ALTER TABLE `har_tutor`
	ADD CONSTRAINT `PK_har_tutor` -- 튜터 기본키
		PRIMARY KEY (
			`tno` -- 튜터번호
		);

-- 튜터문의게시판
CREATE TABLE `har_tqna` (
	`pno`      INTEGER      NOT NULL COMMENT '글번호', -- 글번호
	`mno`      INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	`tno`      INTEGER      NOT NULL COMMENT '튜터번호', -- 튜터번호
	`title`    VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	`secret`   INTEGER      NOT NULL DEFAULT 1 COMMENT '비밀글여부', -- 비밀글여부
	`reply`    LONGTEXT     NOT NULL COMMENT '답변내용', -- 답변내용
	`rpl_dttm` DATETIME     NOT NULL COMMENT '답변일시' -- 답변일시
)
COMMENT '튜터문의게시판';

-- 튜터문의게시판
ALTER TABLE `har_tqna`
	ADD CONSTRAINT `PK_har_tqna` -- 튜터문의게시판 기본키
		PRIMARY KEY (
			`pno` -- 글번호
		);

-- 튜터문의게시판
ALTER TABLE `har_tqna`
	ADD CONSTRAINT `CK_har_tqna` -- 튜터문의게시판 체크 제약
		CHECK (secret = 1 or secret = 0);

-- 튜터문의답글파일
CREATE TABLE `har_trpl_file` (
	`trpl_fno`   INTEGER      NOT NULL COMMENT '파일번호', -- 파일번호
	`trpl_fname` VARCHAR(255) NOT NULL COMMENT '파일명', -- 파일명
	`pno`        INTEGER      NOT NULL COMMENT '글번호' -- 글번호
)
COMMENT '튜터문의답글파일';

-- 튜터문의답글파일
ALTER TABLE `har_trpl_file`
	ADD CONSTRAINT `PK_har_trpl_file` -- 튜터문의답글파일 기본키
		PRIMARY KEY (
			`trpl_fno` -- 파일번호
		);

ALTER TABLE `har_trpl_file`
	MODIFY COLUMN `trpl_fno` INTEGER NOT NULL AUTO_INCREMENT COMMENT '파일번호';

-- 튜터지역
CREATE TABLE `har_tdist` (
	`tno`    INTEGER NOT NULL COMMENT '튜터번호', -- 튜터번호
	`sgg_no` INTEGER NOT NULL COMMENT '시군구번호' -- 시군구번호
)
COMMENT '튜터지역';

-- 튜터지역
ALTER TABLE `har_tdist`
	ADD CONSTRAINT `PK_har_tdist` -- 튜터지역 기본키
		PRIMARY KEY (
			`tno`,    -- 튜터번호
			`sgg_no`  -- 시군구번호
		);

-- 튜터카테고리
CREATE TABLE `har_tcat` (
	`ncat_no` INTEGER NOT NULL COMMENT '소분류번호', -- 소분류번호
	`tno`     INTEGER NOT NULL COMMENT '튜터번호' -- 튜터번호
)
COMMENT '튜터카테고리';

-- 튜터카테고리
ALTER TABLE `har_tcat`
	ADD CONSTRAINT `PK_har_tcat` -- 튜터카테고리 기본키
		PRIMARY KEY (
			`ncat_no`, -- 소분류번호
			`tno`      -- 튜터번호
		);

-- 파일
CREATE TABLE `har_file` (
	`fno`   INTEGER      NOT NULL COMMENT '파일번호', -- 파일번호
	`fname` VARCHAR(255) NOT NULL COMMENT '파일명', -- 파일명
	`pno`   INTEGER      NOT NULL COMMENT '글번호' -- 글번호
)
COMMENT '파일';

-- 파일
ALTER TABLE `har_file`
	ADD CONSTRAINT `PK_har_file` -- 파일 기본키
		PRIMARY KEY (
			`fno` -- 파일번호
		);

ALTER TABLE `har_file`
	MODIFY COLUMN `fno` INTEGER NOT NULL AUTO_INCREMENT COMMENT '파일번호';

-- 판매상품
CREATE TABLE `har_product` (
	`prno`      INTEGER  NOT NULL COMMENT '판매상품번호', -- 판매상품번호
	`tno`       INTEGER  NOT NULL COMMENT '튜터번호', -- 튜터번호
	`deli_info` LONGTEXT NOT NULL COMMENT '배송정보', -- 배송정보
	`rfnd_info` LONGTEXT NOT NULL COMMENT '교환환불정보' -- 교환환불정보
)
COMMENT '판매상품';

-- 판매상품
ALTER TABLE `har_product`
	ADD CONSTRAINT `PK_har_product` -- 판매상품 기본키
		PRIMARY KEY (
			`prno` -- 판매상품번호
		);

-- 판매상품사진
CREATE TABLE `har_prpic` (
	`prpic_no`   INTEGER      NOT NULL COMMENT '판매상품사진번호', -- 판매상품사진번호
	`prpic_name` VARCHAR(255) NOT NULL COMMENT '상품사진명', -- 상품사진명
	`prno`       INTEGER      NOT NULL COMMENT '판매상품번호' -- 판매상품번호
)
COMMENT '판매상품사진';

-- 판매상품사진
ALTER TABLE `har_prpic`
	ADD CONSTRAINT `PK_har_prpic` -- 판매상품사진 기본키
		PRIMARY KEY (
			`prpic_no` -- 판매상품사진번호
		);

ALTER TABLE `har_prpic`
	MODIFY COLUMN `prpic_no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '판매상품사진번호';

-- 판매상품옵션
CREATE TABLE `har_pr_opt` (
	`opt_no`   INTEGER      NOT NULL COMMENT '상품옵션번호', -- 상품옵션번호
	`opt_name` VARCHAR(255) NOT NULL COMMENT '상품옵션명', -- 상품옵션명
	`price`    INTEGER      NOT NULL COMMENT '가격', -- 가격
	`sto_size` INTEGER      NOT NULL DEFAULT 0 COMMENT '재고수량', -- 재고수량
	`sold_cnt` INTEGER      NOT NULL DEFAULT 0 COMMENT '옵션별판매량', -- 옵션별판매량
	`prno`     INTEGER      NOT NULL COMMENT '판매상품번호' -- 판매상품번호
)
COMMENT '판매상품옵션';

-- 판매상품옵션
ALTER TABLE `har_pr_opt`
	ADD CONSTRAINT `PK_har_pr_opt` -- 판매상품옵션 기본키
		PRIMARY KEY (
			`opt_no` -- 상품옵션번호
		);

-- 판매상품옵션
ALTER TABLE `har_pr_opt`
	ADD CONSTRAINT `CK_har_pr_opt` -- 판매상품옵션 체크 제약
		CHECK (sto_size >= 0);

-- 판매상품옵션
ALTER TABLE `har_pr_opt`
	ADD CONSTRAINT `CK_har_pr_opt2` -- 판매상품옵션 체크 제약2
		CHECK (price % 1000 = 0);

ALTER TABLE `har_pr_opt`
	MODIFY COLUMN `opt_no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '상품옵션번호';

-- 판매상품후기추천수
CREATE TABLE `har_prrv_rcm` (
	`mno` INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	`pno` INTEGER NOT NULL COMMENT '글번호' -- 글번호
)
COMMENT '판매상품후기추천수';

-- 판매상품후기추천수
ALTER TABLE `har_prrv_rcm`
	ADD CONSTRAINT `PK_har_prrv_rcm` -- 판매상품후기추천수 기본키
		PRIMARY KEY (
			`mno`, -- 회원번호
			`pno`  -- 글번호
		);

-- 팔로우
CREATE TABLE `har_follow` (
	`mno` INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	`tno` INTEGER NOT NULL COMMENT '튜터번호' -- 튜터번호
)
COMMENT '팔로우';

-- 팔로우
ALTER TABLE `har_follow`
	ADD CONSTRAINT `PK_har_follow` -- 팔로우 기본키
		PRIMARY KEY (
			`mno`, -- 회원번호
			`tno`  -- 튜터번호
		);

-- 회원
CREATE TABLE `har_member` (
	`mno`         INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	`email`       VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
	`password`    VARCHAR(100) NOT NULL COMMENT '비밀번호', -- 비밀번호
	`name`        VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	`nickname`    VARCHAR(50)  NULL     COMMENT '닉네임', -- 닉네임
	`profile_pic` VARCHAR(255) NULL     COMMENT '프로필사진명', -- 프로필사진명
	`bdate`       DATE         NOT NULL COMMENT '생년월일', -- 생년월일
	`tel`         VARCHAR(30)  NOT NULL COMMENT '전화번호', -- 전화번호
	`sex`         INTEGER      NULL     COMMENT '성별', -- 성별
	`zipcode`     VARCHAR(7)   NOT NULL COMMENT '우편번호', -- 우편번호
	`addr`        VARCHAR(255) NOT NULL COMMENT '기본주소', -- 기본주소
	`det_addr`    VARCHAR(255) NULL     COMMENT '상세주소', -- 상세주소
	`rdttm`       DATETIME     NOT NULL DEFAULT now() COMMENT '등록일시', -- 등록일시
	`mrno`        INTEGER      NOT NULL COMMENT '회원등급번호', -- 회원등급번호
	`mstat`       INTEGER      NOT NULL DEFAULT 1 COMMENT '회원상태' -- 회원상태
)
COMMENT '회원';

-- 회원
ALTER TABLE `har_member`
	ADD CONSTRAINT `PK_har_member` -- 회원 기본키
		PRIMARY KEY (
			`mno` -- 회원번호
		);

-- 회원
ALTER TABLE `har_member`
	ADD CONSTRAINT `CK_har_member` -- 회원 체크 제약
		CHECK (sex = 1 or sex = 2);

-- 회원
ALTER TABLE `har_member`
	ADD CONSTRAINT `CK_har_member2` -- 회원 체크 제약2
		CHECK (mstat = 0 or mstat =1);

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX `UIX_har_member`
	ON `har_member` ( -- 회원
		`email` ASC -- 이메일
	);

-- 회원 유니크 인덱스2
CREATE UNIQUE INDEX `UIX_har_member2`
	ON `har_member` ( -- 회원
		`nickname` ASC -- 닉네임
	);

ALTER TABLE `har_member`
	MODIFY COLUMN `mno` INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 회원등급
CREATE TABLE `har_mrank` (
	`mrno`     INTEGER     NOT NULL COMMENT '회원등급번호', -- 회원등급번호
	`mem_rank` VARCHAR(50) NOT NULL COMMENT '관리자, 회원, 튜터' -- 회원등급명
)
COMMENT '회원등급';

-- 회원등급
ALTER TABLE `har_mrank`
	ADD CONSTRAINT `PK_har_mrank` -- 회원등급 기본키
		PRIMARY KEY (
			`mrno` -- 회원등급번호
		);

-- 회원등급 유니크 인덱스
CREATE UNIQUE INDEX `UIX_har_mrank`
	ON `har_mrank` ( -- 회원등급
		`mem_rank` ASC -- 회원등급명
	);

ALTER TABLE `har_mrank`
	MODIFY COLUMN `mrno` INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원등급번호';

-- 대댓글
ALTER TABLE `har_recomment`
	ADD CONSTRAINT `FK_har_comment_TO_har_recomment` -- 댓글 -> 대댓글
		FOREIGN KEY (
			`com_no` -- 댓글번호
		)
		REFERENCES `har_comment` ( -- 댓글
			`com_no` -- 댓글번호
		);

-- 대댓글
ALTER TABLE `har_recomment`
	ADD CONSTRAINT `FK_har_member_TO_har_recomment` -- 회원 -> 대댓글
		FOREIGN KEY (
			`mno` -- 대댓글작성자번호
		)
		REFERENCES `har_member` ( -- 회원
			`mno` -- 회원번호
		);

-- 대댓글좋아요
ALTER TABLE `har_recom_like`
	ADD CONSTRAINT `FK_har_recomment_TO_har_recom_like` -- 대댓글 -> 대댓글좋아요
		FOREIGN KEY (
			`recom_no` -- 대댓글번호
		)
		REFERENCES `har_recomment` ( -- 대댓글
			`recom_no` -- 대댓글번호
		);

-- 대댓글좋아요
ALTER TABLE `har_recom_like`
	ADD CONSTRAINT `FK_har_member_TO_har_recom_like` -- 회원 -> 대댓글좋아요
		FOREIGN KEY (
			`mno` -- 회원번호
		)
		REFERENCES `har_member` ( -- 회원
			`mno` -- 회원번호
		);

-- 댓글
ALTER TABLE `har_comment`
	ADD CONSTRAINT `FK_har_member_TO_har_comment` -- 회원 -> 댓글
		FOREIGN KEY (
			`mno` -- 댓글작성자번호
		)
		REFERENCES `har_member` ( -- 회원
			`mno` -- 회원번호
		);

-- 댓글
ALTER TABLE `har_comment`
	ADD CONSTRAINT `FK_har_feed_TO_har_comment` -- 스토리게시판 -> 댓글
		FOREIGN KEY (
			`feed_no` -- 글번호
		)
		REFERENCES `har_feed` ( -- 스토리게시판
			`feed_no` -- 글번호
		);

-- 댓글좋아요
ALTER TABLE `har_com_like`
	ADD CONSTRAINT `FK_har_member_TO_har_com_like` -- 회원 -> 댓글좋아요
		FOREIGN KEY (
			`mno` -- 회원번호
		)
		REFERENCES `har_member` ( -- 회원
			`mno` -- 회원번호
		);

-- 댓글좋아요
ALTER TABLE `har_com_like`
	ADD CONSTRAINT `FK_har_comment_TO_har_com_like` -- 댓글 -> 댓글좋아요
		FOREIGN KEY (
			`com_no` -- 댓글번호
		)
		REFERENCES `har_comment` ( -- 댓글
			`com_no` -- 댓글번호
		);

-- 상품구매
ALTER TABLE `har_purchase`
	ADD CONSTRAINT `FK_har_member_TO_har_purchase` -- 회원 -> 상품구매
		FOREIGN KEY (
			`mno` -- 구매회원번호
		)
		REFERENCES `har_member` ( -- 회원
			`mno` -- 회원번호
		);

-- 상품구매
ALTER TABLE `har_purchase`
	ADD CONSTRAINT `FK_har_pr_opt_TO_har_purchase` -- 판매상품옵션 -> 상품구매
		FOREIGN KEY (
			`opt_no` -- 상품옵션번호
		)
		REFERENCES `har_pr_opt` ( -- 판매상품옵션
			`opt_no` -- 상품옵션번호
		);

-- 상품구매후기
ALTER TABLE `har_prrv`
	ADD CONSTRAINT `FK_har_post_TO_har_prrv` -- 글 -> 상품구매후기
		FOREIGN KEY (
			`pno` -- 글번호
		)
		REFERENCES `har_post` ( -- 글
			`pno` -- 글번호
		);

-- 상품구매후기
ALTER TABLE `har_prrv`
	ADD CONSTRAINT `FK_har_purchase_TO_har_prrv` -- 상품구매 -> 상품구매후기
		FOREIGN KEY (
			`purc_no` -- 상품옵션구매번호
		)
		REFERENCES `har_purchase` ( -- 상품구매
			`purc_no` -- 상품옵션구매번호
		);

-- 상품장바구니
ALTER TABLE `har_pr_cart`
	ADD CONSTRAINT `FK_har_member_TO_har_pr_cart` -- 회원 -> 상품장바구니
		FOREIGN KEY (
			`mno` -- 회원번호
		)
		REFERENCES `har_member` ( -- 회원
			`mno` -- 회원번호
		);

-- 상품장바구니
ALTER TABLE `har_pr_cart`
	ADD CONSTRAINT `FK_har_pr_opt_TO_har_pr_cart` -- 판매상품옵션 -> 상품장바구니
		FOREIGN KEY (
			`opt_no` -- 상품옵션번호
		)
		REFERENCES `har_pr_opt` ( -- 판매상품옵션
			`opt_no` -- 상품옵션번호
		);

-- 서비스기본정보
ALTER TABLE `har_service`
	ADD CONSTRAINT `FK_har_narrow_cat_TO_har_service` -- 소분류 -> 서비스기본정보
		FOREIGN KEY (
			`ncat_no` -- 소분류번호
		)
		REFERENCES `har_narrow_cat` ( -- 소분류
			`ncat_no` -- 소분류번호
		);

-- 서비스문의글
ALTER TABLE `har_sqna`
	ADD CONSTRAINT `FK_har_post_TO_har_sqna` -- 글 -> 서비스문의글
		FOREIGN KEY (
			`pno` -- 글번호
		)
		REFERENCES `har_post` ( -- 글
			`pno` -- 글번호
		);

-- 서비스문의글
ALTER TABLE `har_sqna`
	ADD CONSTRAINT `FK_har_service_TO_har_sqna` -- 서비스기본정보 -> 서비스문의글
		FOREIGN KEY (
			`sno` -- 서비스번호
		)
		REFERENCES `har_service` ( -- 서비스기본정보
			`sno` -- 서비스번호
		);

-- 서비스문의글
ALTER TABLE `har_sqna`
	ADD CONSTRAINT `FK_har_member_TO_har_sqna` -- 회원 -> 서비스문의글
		FOREIGN KEY (
			`mno` -- 회원번호
		)
		REFERENCES `har_member` ( -- 회원
			`mno` -- 회원번호
		);

-- 서비스문의답글파일
ALTER TABLE `har_srpl_file`
	ADD CONSTRAINT `FK_har_sqna_TO_har_srpl_file` -- 서비스문의글 -> 서비스문의답글파일
		FOREIGN KEY (
			`pno` -- 글번호
		)
		REFERENCES `har_sqna` ( -- 서비스문의글
			`pno` -- 글번호
		);

-- 소분류
ALTER TABLE `har_narrow_cat`
	ADD CONSTRAINT `FK_har_broad_cat_TO_har_narrow_cat` -- 대분류 -> 소분류
		FOREIGN KEY (
			`bcat_no` -- 대분류번호
		)
		REFERENCES `har_broad_cat` ( -- 대분류
			`bcat_no` -- 대분류번호
		);

-- 수업일정
ALTER TABLE `har_schedule`
	ADD CONSTRAINT `FK_har_learning_TO_har_schedule` -- 체험학습 -> 수업일정
		FOREIGN KEY (
			`lno` -- 체험학습번호
		)
		REFERENCES `har_learning` ( -- 체험학습
			`lno` -- 체험학습번호
		);

-- 스토리게시판
ALTER TABLE `har_feed`
	ADD CONSTRAINT `FK_har_post_TO_har_feed` -- 글 -> 스토리게시판
		FOREIGN KEY (
			`feed_no` -- 글번호
		)
		REFERENCES `har_post` ( -- 글
			`pno` -- 글번호
		);

-- 스토리게시판
ALTER TABLE `har_feed`
	ADD CONSTRAINT `FK_har_tutor_TO_har_feed` -- 튜터 -> 스토리게시판
		FOREIGN KEY (
			`tno` -- 튜터번호
		)
		REFERENCES `har_tutor` ( -- 튜터
			`tno` -- 튜터번호
		);

-- 스토리좋아요
ALTER TABLE `har_feed_like`
	ADD CONSTRAINT `FK_har_feed_TO_har_feed_like` -- 스토리게시판 -> 스토리좋아요
		FOREIGN KEY (
			`feed_no` -- 글번호
		)
		REFERENCES `har_feed` ( -- 스토리게시판
			`feed_no` -- 글번호
		);

-- 스토리좋아요
ALTER TABLE `har_feed_like`
	ADD CONSTRAINT `FK_har_member_TO_har_feed_like` -- 회원 -> 스토리좋아요
		FOREIGN KEY (
			`mno` -- 회원번호
		)
		REFERENCES `har_member` ( -- 회원
			`mno` -- 회원번호
		);

-- 시군구
ALTER TABLE `har_sigungu`
	ADD CONSTRAINT `FK_har_sido_TO_har_sigungu` -- 광역시도 -> 시군구
		FOREIGN KEY (
			`sido_no` -- 광역시도번호
		)
		REFERENCES `har_sido` ( -- 광역시도
			`sido_no` -- 광역시도번호
		);

-- 위시리스트
ALTER TABLE `har_wishlist`
	ADD CONSTRAINT `FK_har_member_TO_har_wishlist` -- 회원 -> 위시리스트
		FOREIGN KEY (
			`mno` -- 회원번호
		)
		REFERENCES `har_member` ( -- 회원
			`mno` -- 회원번호
		);

-- 위시리스트
ALTER TABLE `har_wishlist`
	ADD CONSTRAINT `FK_har_service_TO_har_wishlist` -- 서비스기본정보 -> 위시리스트
		FOREIGN KEY (
			`sno` -- 서비스번호
		)
		REFERENCES `har_service` ( -- 서비스기본정보
			`sno` -- 서비스번호
		);

-- 체험장바구니
ALTER TABLE `har_lrn_cart`
	ADD CONSTRAINT `FK_har_member_TO_har_lrn_cart` -- 회원 -> 체험장바구니
		FOREIGN KEY (
			`mno` -- 회원번호
		)
		REFERENCES `har_member` ( -- 회원
			`mno` -- 회원번호
		);

-- 체험장바구니
ALTER TABLE `har_lrn_cart`
	ADD CONSTRAINT `FK_har_schedule_TO_har_lrn_cart` -- 수업일정 -> 체험장바구니
		FOREIGN KEY (
			`sche_no` -- 수업일정번호
		)
		REFERENCES `har_schedule` ( -- 수업일정
			`sche_no` -- 수업일정번호
		);

-- 체험학습
ALTER TABLE `har_learning`
	ADD CONSTRAINT `FK_har_service_TO_har_learning` -- 서비스기본정보 -> 체험학습
		FOREIGN KEY (
			`lno` -- 체험학습번호
		)
		REFERENCES `har_service` ( -- 서비스기본정보
			`sno` -- 서비스번호
		);

-- 체험학습
ALTER TABLE `har_learning`
	ADD CONSTRAINT `FK_har_sigungu_TO_har_learning` -- 시군구 -> 체험학습
		FOREIGN KEY (
			`sgg_no` -- 시군구번호
		)
		REFERENCES `har_sigungu` ( -- 시군구
			`sgg_no` -- 시군구번호
		);

-- 체험학습
ALTER TABLE `har_learning`
	ADD CONSTRAINT `FK_har_tutor_TO_har_learning` -- 튜터 -> 체험학습
		FOREIGN KEY (
			`tno` -- 튜터번호
		)
		REFERENCES `har_tutor` ( -- 튜터
			`tno` -- 튜터번호
		);

-- 체험학습신청
ALTER TABLE `har_lrn_appl`
	ADD CONSTRAINT `FK_har_member_TO_har_lrn_appl` -- 회원 -> 체험학습신청
		FOREIGN KEY (
			`mno` -- 신청회원번호
		)
		REFERENCES `har_member` ( -- 회원
			`mno` -- 회원번호
		);

-- 체험학습신청
ALTER TABLE `har_lrn_appl`
	ADD CONSTRAINT `FK_har_schedule_TO_har_lrn_appl` -- 수업일정 -> 체험학습신청
		FOREIGN KEY (
			`sche_no` -- 수업일정번호
		)
		REFERENCES `har_schedule` ( -- 수업일정
			`sche_no` -- 수업일정번호
		);

-- 체험학습후기
ALTER TABLE `har_lrnrv`
	ADD CONSTRAINT `FK_har_lrn_appl_TO_har_lrnrv` -- 체험학습신청 -> 체험학습후기
		FOREIGN KEY (
			`lrn_appl_no` -- 체험학습신청번호
		)
		REFERENCES `har_lrn_appl` ( -- 체험학습신청
			`lrn_appl_no` -- 체험학습신청번호
		);

-- 체험학습후기
ALTER TABLE `har_lrnrv`
	ADD CONSTRAINT `FK_har_post_TO_har_lrnrv` -- 글 -> 체험학습후기
		FOREIGN KEY (
			`pno` -- 글번호
		)
		REFERENCES `har_post` ( -- 글
			`pno` -- 글번호
		);

-- 체험후기추천수
ALTER TABLE `har_lrnrv_rcm`
	ADD CONSTRAINT `FK_har_member_TO_har_lrnrv_rcm` -- 회원 -> 체험후기추천수
		FOREIGN KEY (
			`mno` -- 회원번호
		)
		REFERENCES `har_member` ( -- 회원
			`mno` -- 회원번호
		);

-- 체험후기추천수
ALTER TABLE `har_lrnrv_rcm`
	ADD CONSTRAINT `FK_har_lrnrv_TO_har_lrnrv_rcm` -- 체험학습후기 -> 체험후기추천수
		FOREIGN KEY (
			`pno` -- 글번호
		)
		REFERENCES `har_lrnrv` ( -- 체험학습후기
			`pno` -- 글번호
		);

-- 튜터
ALTER TABLE `har_tutor`
	ADD CONSTRAINT `FK_har_member_TO_har_tutor` -- 회원 -> 튜터
		FOREIGN KEY (
			`tno` -- 튜터번호
		)
		REFERENCES `har_member` ( -- 회원
			`mno` -- 회원번호
		);

-- 튜터문의게시판
ALTER TABLE `har_tqna`
	ADD CONSTRAINT `FK_har_member_TO_har_tqna` -- 회원 -> 튜터문의게시판
		FOREIGN KEY (
			`mno` -- 회원번호
		)
		REFERENCES `har_member` ( -- 회원
			`mno` -- 회원번호
		);

-- 튜터문의게시판
ALTER TABLE `har_tqna`
	ADD CONSTRAINT `FK_har_post_TO_har_tqna` -- 글 -> 튜터문의게시판
		FOREIGN KEY (
			`pno` -- 글번호
		)
		REFERENCES `har_post` ( -- 글
			`pno` -- 글번호
		);

-- 튜터문의게시판
ALTER TABLE `har_tqna`
	ADD CONSTRAINT `FK_har_tutor_TO_har_tqna` -- 튜터 -> 튜터문의게시판
		FOREIGN KEY (
			`tno` -- 튜터번호
		)
		REFERENCES `har_tutor` ( -- 튜터
			`tno` -- 튜터번호
		);

-- 튜터문의답글파일
ALTER TABLE `har_trpl_file`
	ADD CONSTRAINT `FK_har_tqna_TO_har_trpl_file` -- 튜터문의게시판 -> 튜터문의답글파일
		FOREIGN KEY (
			`pno` -- 글번호
		)
		REFERENCES `har_tqna` ( -- 튜터문의게시판
			`pno` -- 글번호
		);

-- 튜터지역
ALTER TABLE `har_tdist`
	ADD CONSTRAINT `FK_har_tutor_TO_har_tdist` -- 튜터 -> 튜터지역
		FOREIGN KEY (
			`tno` -- 튜터번호
		)
		REFERENCES `har_tutor` ( -- 튜터
			`tno` -- 튜터번호
		);

-- 튜터지역
ALTER TABLE `har_tdist`
	ADD CONSTRAINT `FK_har_sigungu_TO_har_tdist` -- 시군구 -> 튜터지역
		FOREIGN KEY (
			`sgg_no` -- 시군구번호
		)
		REFERENCES `har_sigungu` ( -- 시군구
			`sgg_no` -- 시군구번호
		);

-- 튜터카테고리
ALTER TABLE `har_tcat`
	ADD CONSTRAINT `FK_har_narrow_cat_TO_har_tcat` -- 소분류 -> 튜터카테고리
		FOREIGN KEY (
			`ncat_no` -- 소분류번호
		)
		REFERENCES `har_narrow_cat` ( -- 소분류
			`ncat_no` -- 소분류번호
		);

-- 튜터카테고리
ALTER TABLE `har_tcat`
	ADD CONSTRAINT `FK_har_tutor_TO_har_tcat` -- 튜터 -> 튜터카테고리
		FOREIGN KEY (
			`tno` -- 튜터번호
		)
		REFERENCES `har_tutor` ( -- 튜터
			`tno` -- 튜터번호
		);

-- 파일
ALTER TABLE `har_file`
	ADD CONSTRAINT `FK_har_post_TO_har_file` -- 글 -> 파일
		FOREIGN KEY (
			`pno` -- 글번호
		)
		REFERENCES `har_post` ( -- 글
			`pno` -- 글번호
		);

-- 판매상품
ALTER TABLE `har_product`
	ADD CONSTRAINT `FK_har_service_TO_har_product` -- 서비스기본정보 -> 판매상품
		FOREIGN KEY (
			`prno` -- 판매상품번호
		)
		REFERENCES `har_service` ( -- 서비스기본정보
			`sno` -- 서비스번호
		);

-- 판매상품
ALTER TABLE `har_product`
	ADD CONSTRAINT `FK_har_tutor_TO_har_product` -- 튜터 -> 판매상품
		FOREIGN KEY (
			`tno` -- 튜터번호
		)
		REFERENCES `har_tutor` ( -- 튜터
			`tno` -- 튜터번호
		);

-- 판매상품사진
ALTER TABLE `har_prpic`
	ADD CONSTRAINT `FK_har_product_TO_har_prpic` -- 판매상품 -> 판매상품사진
		FOREIGN KEY (
			`prno` -- 판매상품번호
		)
		REFERENCES `har_product` ( -- 판매상품
			`prno` -- 판매상품번호
		);

-- 판매상품옵션
ALTER TABLE `har_pr_opt`
	ADD CONSTRAINT `FK_har_product_TO_har_pr_opt` -- 판매상품 -> 판매상품옵션
		FOREIGN KEY (
			`prno` -- 판매상품번호
		)
		REFERENCES `har_product` ( -- 판매상품
			`prno` -- 판매상품번호
		);

-- 판매상품후기추천수
ALTER TABLE `har_prrv_rcm`
	ADD CONSTRAINT `FK_har_prrv_TO_har_prrv_rcm` -- 상품구매후기 -> 판매상품후기추천수
		FOREIGN KEY (
			`pno` -- 글번호
		)
		REFERENCES `har_prrv` ( -- 상품구매후기
			`pno` -- 글번호
		);

-- 판매상품후기추천수
ALTER TABLE `har_prrv_rcm`
	ADD CONSTRAINT `FK_har_member_TO_har_prrv_rcm` -- 회원 -> 판매상품후기추천수
		FOREIGN KEY (
			`mno` -- 회원번호
		)
		REFERENCES `har_member` ( -- 회원
			`mno` -- 회원번호
		);

-- 팔로우
ALTER TABLE `har_follow`
	ADD CONSTRAINT `FK_har_member_TO_har_follow` -- 회원 -> 팔로우
		FOREIGN KEY (
			`mno` -- 회원번호
		)
		REFERENCES `har_member` ( -- 회원
			`mno` -- 회원번호
		);

-- 팔로우
ALTER TABLE `har_follow`
	ADD CONSTRAINT `FK_har_tutor_TO_har_follow` -- 튜터 -> 팔로우
		FOREIGN KEY (
			`tno` -- 튜터번호
		)
		REFERENCES `har_tutor` ( -- 튜터
			`tno` -- 튜터번호
		);

-- 회원
ALTER TABLE `har_member`
	ADD CONSTRAINT `FK_har_mrank_TO_har_member` -- 회원등급 -> 회원
		FOREIGN KEY (
			`mrno` -- 회원등급번호
		)
		REFERENCES `har_mrank` ( -- 회원등급
			`mrno` -- 회원등급번호
		);
    
-- 고정 데이터 삽입 sql
-- 회원등급
insert into har_mrank (mrno, mem_rank)
values (1, '관리자');

insert into har_mrank (mrno, mem_rank)
values (2, '튜터');

insert into har_mrank (mrno, mem_rank)
values (3, '회원');

-- 대분류
insert into har_broad_cat (bcat_no, bcat_name)
values (1, '공예·DIY');
insert into har_broad_cat (bcat_no, bcat_name)
values (2, '댄스');
insert into har_broad_cat (bcat_no, bcat_name)
values (3, '요리');
insert into har_broad_cat (bcat_no, bcat_name)
values (4, '음료');
insert into har_broad_cat (bcat_no, bcat_name)
values (5, '음악·예술');
insert into har_broad_cat (bcat_no, bcat_name)
values (6, '스포츠');
insert into har_broad_cat (bcat_no, bcat_name)
values (7, '사진·영상');
insert into har_broad_cat (bcat_no, bcat_name)
values (8, '미술·드로잉');
insert into har_broad_cat (bcat_no, bcat_name)
values (9, '뷰티');

-- 소분류
-- 공예·DIY
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (1, 1, '도자기');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (2, 1, '가죽');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (3, 1, '목공');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (4, 1, '플라워');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (5, 1, '향수');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (6, 1, '뜨개·자수');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (7, 1, '캔들·석고방향제');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (8, 1, '비누');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (9, 1, '라탄·마크라메');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (10, 1, '액세서리·비즈');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (11, 1, '조명·네온사인');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (12, 1, '기타');

-- 댄스
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (13, 2, '방송댄스');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (14, 2, '스포츠댄스');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (15, 2, '폴댄스');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (16, 2, '벨리댄스');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (17, 2, '탭댄스');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (18, 2, '힙합댄스');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (19, 2, '기타');

-- 요리
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (20, 3, '한식');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (21, 3, '일식');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (22, 3, '중식');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (23, 3, '양식');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (24, 3, '베이킹·디저트');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (25, 3, '비건·키토');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (26, 3, '기타');


-- 음료
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (27, 4, '맥주');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (28, 4, '와인');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (29, 4, '칵테일·위스키');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (30, 4, '전통주');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (31, 4, '커피·차');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (32, 4, '기타');

-- 음악·예술
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (33, 5, '피아노');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (34, 5, '기타(악기)');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (35, 5, '드럼');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (36, 5, '서양악기');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (37, 5, '동양악기');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (38, 5, '보컬');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (39, 5, '연기·공연');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (40, 5, '기타');

-- 스포츠
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (41, 6, '클라이밍');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (42, 6, '구기스포츠');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (43, 6, '라켓스포츠');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (44, 6, '무도');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (45, 6, '요가');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (46, 6, '필라테스');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (47, 6, '피트니스');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (48, 6, '발레');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (49, 6, '수영');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (50, 6, '등산·트레킹');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (51, 6, '러닝·라이딩');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (52, 6, '스키·스노우보드');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (53, 6, '서핑·SUP');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (54, 6, '수상레저');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (55, 6, '기타');

-- 사진·영상 
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (56, 7, '사진');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (57, 7, '영상');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (58, 7, '기타');

-- 미술·드로잉 
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (59, 8, '동양화');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (60, 8, '서양화');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (61, 8, '캘리그라피·드로잉');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (62, 8, '기타');

-- 뷰티 
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (63, 9, '헤어·메이크업');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (64, 9, '이미지메이킹');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (65, 9, '네일·왁싱');
insert into har_narrow_cat (ncat_no, bcat_no, ncat_name)
values (66, 9, '기타');

-- 광역시도
insert into har_sido (sido_no, sido_name)
values (1, '서울'); -- 특별시
insert into har_sido (sido_no, sido_name)
values (2, '경기');
insert into har_sido (sido_no, sido_name)
values (3, '인천'); -- 광역시
insert into har_sido (sido_no, sido_name)
values (4, '강원');
insert into har_sido (sido_no, sido_name)
values (5, '부산'); -- 광역시
insert into har_sido (sido_no, sido_name)
values (6, '대구'); -- 광역시
insert into har_sido (sido_no, sido_name)
values (7, '대전'); -- 광역시
insert into har_sido (sido_no, sido_name)
values (8, '울산'); -- 광역시
insert into har_sido (sido_no, sido_name)
values (9, '경북');
insert into har_sido (sido_no, sido_name)
values (10, '경남');
insert into har_sido (sido_no, sido_name)
values (11, '충북');
insert into har_sido (sido_no, sido_name)
values (12, '충남');
insert into har_sido (sido_no, sido_name)
values (13, '전북');
insert into har_sido (sido_no, sido_name)
values (14, '전남');
insert into har_sido (sido_no, sido_name)
values (15, '광주'); -- 광역시
insert into har_sido (sido_no, sido_name)
values (16, '세종'); -- 특별자치시
insert into har_sido (sido_no, sido_name)
values (17, '제주');

-- 서울
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (1, 1, '도봉구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (2, 1, '노원구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (3, 1, '강북구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (4, 1, '중랑구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (5, 1, '성북구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (6, 1, '종로구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (7, 1, '동대문구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (8, 1, '은평구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (9, 1, '서대문구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (10, 1, '중구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (11, 1, '성동구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (12, 1, '광진구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (13, 1, '마포구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (14, 1, '용산구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (15, 1, '강동구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (16, 1, '강서구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (17, 1, '양천구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (18, 1, '영등포구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (19, 1, '동작구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (20, 1, '서초구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (21, 1, '강남구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (22, 1, '송파구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (23, 1, '구로구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (24, 1, '금천구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (25, 1, '관악구');

-- 경기
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (26, 2, '김포');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (27, 2, '파주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (28, 2, '연천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (29, 2, '고양');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (30, 2, '양주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (31, 2, '동두천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (32, 2, '포천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (33, 2, '의정부');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (34, 2, '구리');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (35, 2, '남양주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (36, 2, '가평');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (37, 2, '하남');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (38, 2, '양평');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (39, 2, '부천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (40, 2, '광명');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (41, 2, '시흥');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (42, 2, '안산');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (43, 2, '안양');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (44, 2, '군포');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (45, 2, '과천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (46, 2, '의왕');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (47, 2, '수원');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (48, 2, '화성');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (49, 2, '오산');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (50, 2, '평택');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (51, 2, '성남');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (52, 2, '광주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (53, 2, '용인');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (54, 2, '이천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (55, 2, '여주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (56, 2, '안성');

-- 인천
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (57, 3, '남동구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (58, 3, '연수구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (59, 3, '미추홀구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (60, 3, '서구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (61, 3, '부평구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (62, 3, '계양구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (63, 3, '동구');

-- 강원
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (64, 4, '철원');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (65, 4, '화천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (66, 4, '양구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (67, 4, '고성');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (68, 4, '인제');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (69, 4, '춘천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (70, 4, '양양');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (71, 4, '홍천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (72, 4, '횡성');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (73, 4, '평창');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (74, 4, '강릉');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (75, 4, '원주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (76, 4, '영월');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (77, 4, '정선');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (78, 4, '태백');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (79, 4, '삼척');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (80, 4, '동해');

-- 부산
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (81, 5, '강서구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (82, 5, '북구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (83, 5, '금정구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (84, 5, '기장군');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (85, 5, '사상구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (86, 5, '부산진구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (87, 5, '동래구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (88, 5, '해운대구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (89, 5, '연제구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (90, 5, '수영구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (91, 5, '서구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (92, 5, '동구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (93, 5, '남구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (94, 5, '중구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (95, 5, '사하구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (96, 5, '영도구');

-- 대구
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (97, 6, '달성군');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (98, 6, '북구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (99, 6, '동구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (100, 6, '서구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (101, 6, '중구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (102, 6, '남구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (103, 6, '달서구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (104, 6, '수성구');

-- 대전
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (105, 7, '동구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (106, 7, '서구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (107, 7, '중구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (108, 7, '유성구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (109, 7, '대덕구');

-- 울산
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (110, 8, '울주군');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (111, 8, '동구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (112, 8, '중구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (113, 8, '남구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (114, 8, '북구');

-- 경북
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (115, 9, '영주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (116, 9, '봉화');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (117, 9, '울진');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (118, 9, '문경');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (119, 9, '예천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (120, 9, '안동');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (121, 9, '영양');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (122, 9, '상주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (123, 9, '영덕');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (124, 9, '의성');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (125, 9, '청송');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (126, 9, '구미');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (127, 9, '김천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (128, 9, '김천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (129, 9, '칠곡');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (130, 9, '군위');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (131, 9, '영천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (132, 9, '포항');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (133, 9, '성주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (134, 9, '고령');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (135, 9, '경주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (136, 9, '청도');

-- 경남
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (137, 10, '거창');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (138, 10, '함양');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (139, 10, '산청');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (140, 10, '합천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (141, 10, '하동');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (142, 10, '진주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (143, 10, '의령');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (144, 10, '창녕');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (145, 10, '사천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (146, 10, '함안');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (147, 10, '밀양');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (148, 10, '양산');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (149, 10, '김해');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (150, 10, '창원');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (151, 10, '고양');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (152, 10, '남해');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (153, 10, '통영');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (154, 10, '거제');

-- 충북
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (155, 11, '청주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (156, 11, '충주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (157, 11, '제천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (158, 11, '보은');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (159, 11, '옥천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (160, 11, '영동');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (161, 11, '증평');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (162, 11, '진천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (163, 11, '괴산');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (164, 11, '음성');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (165, 11, '단양');

-- 충남
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (166, 12, '태안');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (167, 12, '서산');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (168, 12, '당진');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (169, 12, '홍성');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (170, 12, '예산');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (171, 12, '아산');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (172, 12, '천안');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (173, 12, '보령');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (174, 12, '청양');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (175, 12, '공주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (176, 12, '서천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (177, 12, '부여');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (178, 12, '논산');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (179, 12, '계룡');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (180, 12, '금산');

-- 전북
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (181, 13, '익산');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (182, 13, '군산');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (183, 13, '완주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (184, 13, '진안');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (185, 13, '무주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (186, 13, '김제');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (187, 13, '전주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (188, 13, '부안');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (189, 13, '정읍');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (190, 13, '고창');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (191, 13, '순창');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (192, 13, '임실');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (193, 13, '남원');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (194, 13, '장수');

-- 전남
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (195, 14, '목포');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (196, 14, '여수');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (197, 14, '순천');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (198, 14, '나주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (199, 14, '광양');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (200, 14, '담양');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (201, 14, '곡성');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (202, 14, '구례');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (203, 14, '고흥');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (204, 14, '보성');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (205, 14, '화순');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (206, 14, '장흥');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (207, 14, '강진');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (208, 14, '해남');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (209, 14, '영암');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (210, 14, '무안');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (211, 14, '함평');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (212, 14, '영광');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (213, 14, '장성');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (214, 14, '완도');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (215, 14, '진도');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (216, 14, '신안');

-- 광주
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (217, 15, '광산구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (218, 15, '북구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (219, 15, '서구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (220, 15, '남구');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (221, 15, '동구');

-- 세종
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (222, 16, '세종');

-- 제주
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (223, 17, '제주');
insert into har_sigungu (sgg_no, sido_no, sgg_name)
values (224, 17, '서귀포');