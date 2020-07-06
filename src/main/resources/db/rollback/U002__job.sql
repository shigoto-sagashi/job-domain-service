CREATE TABLE EXAMPLE_ENTITY (
                                TEST_ID CHAR(36) NOT NULL,
                                TEXT_TEST VARCHAR(100) NULL,
                                NUMBER_TEST INTEGER NOT NULL,
                                DATETIME_TEST BIGINT(20) NOT NULL,
                                PRIMARY KEY(TEST_ID)
);
DROP TABLE JOB_ENTITY;

DELETE FROM schema_version WHERE version = '002';