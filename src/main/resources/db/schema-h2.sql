CREATE TABLE IF NOT EXISTS timed_task
(
    id       BIGINT(20)   NOT NULL COMMENT '主键ID',
    username VARCHAR(100) NULL DEFAULT NULL COMMENT '账号',
    password VARCHAR(32)  NULL DEFAULT NULL COMMENT '密码',
    step     INT(5)       NULL DEFAULT NULL COMMENT '步数',
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS timed_task_success_log
(
    id            BIGINT(20) NOT NULL COMMENT '主键ID',
    task_id       BIGINT(20) NULL DEFAULT NULL COMMENT '定时任务ID',
    response_json TEXT       NULL DEFAULT NULL COMMENT '响应json',
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS timed_task_error_log
(
    id            BIGINT(20) NOT NULL COMMENT '主键ID',
    task_id       BIGINT(20) NULL DEFAULT NULL COMMENT '定时任务ID',
    response_json TEXT       NULL DEFAULT NULL COMMENT '响应json',
    PRIMARY KEY (id)
);
