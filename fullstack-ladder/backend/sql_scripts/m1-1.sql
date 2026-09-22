-- 建表SQL
CREATE TABLE
  users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID（自增代理键）',
    username VARCHAR(50) NOT NULL UNIQUE COMMENT '登录名',
    password_hash VARCHAR(100) NOT NULL COMMENT '密码哈希',
    nickname VARCHAR(50) NOT NULL COMMENT '昵称',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = '用户表';

CREATE TABLE
  questions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '题目ID',
    stem TEXT NOT NULL COMMENT '题干',
    options JSON NOT NULL COMMENT '选项数组，如 ["选项A","选项B","选项C","选项D"]',
    answer VARCHAR(2) NOT NULL COMMENT '正确答案选项字母',
    difficulty VARCHAR(8) NOT NULL DEFAULT 'EASY' COMMENT '难度：EASY/MEDIUM/HARD',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = '题目表';

CREATE TABLE
  answer_records (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '记录ID',
    user_id BIGINT NOT NULL COMMENT '答题主（逻辑外键 → users.id）',
    question_id BIGINT NOT NULL COMMENT '题目（逻辑外键 → questions.id）',
    selected VARCHAR(2) NOT NULL COMMENT '用户所选选项字母',
    is_correct TINYINT (1) NOT NULL DEFAULT 0 COMMENT '是否答对：0/1',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    KEY idx_user_id (user_id),
    KEY idx_question_id (question_id)
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = '作答记录表';

-- 插入数据SQL
INSERT INTO
  questions (stem, options, answer, difficulty)
VALUES
  ('Vue 3 中 ref 和 reactive 的区别，正确的是？', '["ref 包装基本类型，reactive 包装对象","两者完全等价","reactive 可整体替换","ref 不能用于对象"]', 'A', 'EASY'),
  ('Java 中定义接口的关键字是？', '["interface","struct","protocol","trait"]', 'A', 'EASY'),
  ('MySQL 中查看表结构的命令是？', '["DESC 表名","SHOW ME 表名","STRUCTURE 表名","PRINT 表名"]', 'A', 'MEDIUM');

INSERT INTO
  users (username, password_hash, nickname)
VALUES
  ('zhangsan', 'placeholder', '张三'),
  ('lisi', 'placeholder', '李四');

UPDATE users
SET
  nickname = '张三丰'
WHERE
  username = 'zhangsan';