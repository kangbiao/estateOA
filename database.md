``` sql
CREATE TABLE apartment
(
    apartment_id INT UNSIGNED,
    unit_code INT,
    code INT,
    building_id INT UNSIGNED,
    id INT NOT NULL
);
CREATE TABLE app_user
(
    phone VARCHAR(15) PRIMARY KEY NOT NULL,
    passwd VARCHAR(45),
    user_role TINYINT,
    user_name VARCHAR(45),
    register_time BIGINT
);
CREATE TABLE authenticated_record
(
    id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    applicant VARCHAR(45),
    application_time BIGINT,
    application_type TINYINT,
    auth_id INT UNSIGNED,
    auth_result TINYINT,
    auth_time BIGINT
);
CREATE TABLE authenticated_user
(
    au_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(45),
    identity_id VARCHAR(45),
    owner_relationship VARCHAR(20),
    birthday BIGINT,
    register_time BIGINT,
    sex TINYINT,
    bound_time BIGINT,
    is_bound TINYINT,
    familycol VARCHAR(45),
    owner_id INT UNSIGNED,
    user_id INT UNSIGNED
);
CREATE TABLE bill
(
    id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    property_id INT UNSIGNED,
    fee_item_fee VARCHAR(255),
    pay_status TINYINT,
    pay_type TINYINT,
    pay_time BIGINT,
    bill_generation_time BIGINT,
    overdue_fee DECIMAL(11,2),
    payer VARCHAR(45)
);
CREATE TABLE building
(
    building_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    village_id INT UNSIGNED,
    description VARCHAR(45),
    building_code VARCHAR(45)
);
CREATE TABLE complain
(
    id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title VARCHAR(100),
    content LONGTEXT,
    description VARCHAR(100),
    user_id INT UNSIGNED,
    time BIGINT,
    image_id_list VARCHAR(50),
    type TINYINT,
    status TINYINT,
    admin_id INT,
    remark TINYINT,
    result VARCHAR(200)
);
CREATE TABLE console_group
(
    cg_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(45),
    authorization VARCHAR(255)
);
CREATE TABLE console_user
(
    cu_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    password VARCHAR(45),
    phone VARCHAR(45),
    email VARCHAR(45),
    console_group_id INT,
    name VARCHAR(45),
    identity_type TINYINT,
    identity_id VARCHAR(45),
    remark INT
);
CREATE TABLE family
(
    family_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    phone VARCHAR(15),
    name VARCHAR(45),
    sex TINYINT,
    birthday BIGINT,
    urgent_name VARCHAR(45),
    urgent_phone VARCHAR(15),
    identity_type TINYINT,
    identity_code VARCHAR(45),
    owner_relationship VARCHAR(20),
    authentication_time BIGINT,
    vehicle_id_list VARCHAR(50),
    auth_status TINYINT,
    owner_id INT UNSIGNED
);
CREATE TABLE fee_item
(
    fi_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    decription VARCHAR(200),
    fee_type_id INT UNSIGNED,
    rule_id INT UNSIGNED,
    is_periodic TINYINT,
    village_id INT UNSIGNED
);
CREATE TABLE fee_item_order
(
    id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    property_id INT UNSIGNED,
    fee_item_id INT UNSIGNED,
    is_billed TINYINT
);
CREATE TABLE fee_type
(
    ft_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    description VARCHAR(200)
);
CREATE TABLE notice
(
    notice_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title VARCHAR(100),
    content LONGTEXT,
    time BIGINT,
    picture_id_list VARCHAR(100),
    description VARCHAR(100),
    type TINYINT,
    expiretime INT,
    cu_id INT UNSIGNED
);
CREATE TABLE open_door_record
(
    id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED,
    open_time BIGINT,
    open_code VARCHAR(100)
);
CREATE TABLE owner
(
    owner_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    phone VARCHAR(15),
    name VARCHAR(45),
    sex TINYINT,
    birthday BIGINT,
    urgent_name VARCHAR(45),
    urgent_phone VARCHAR(20),
    identity_type TINYINT,
    identity_code VARCHAR(45),
    vehicle_id_ist VARCHAR(50),
    property_id_list VARCHAR(50),
    authentication_time BIGINT
);
CREATE TABLE parking_lot
(
    property_id INT UNSIGNED,
    code VARCHAR(45),
    floor VARCHAR(45),
    type TINYINT,
    description VARCHAR(100),
    id INT NOT NULL
);
CREATE TABLE picture
(
    picture_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(45),
    description VARCHAR(45),
    dir VARCHAR(100)
);
CREATE TABLE property
(
    property_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    code VARCHAR(45),
    owner_name_list VARCHAR(100),
    location VARCHAR(100),
    type TINYINT,
    property_square DECIMAL(11,2),
    owner_type TINYINT,
    village_id INT UNSIGNED,
    status TINYINT
);
CREATE TABLE property_owner_info
(
    po_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    property_id INT UNSIGNED,
    owner_identity_id VARCHAR(45),
    open_door_allowed TINYINT
);
CREATE TABLE repair
(
    id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title VARCHAR(100),
    content LONGTEXT,
    description VARCHAR(100),
    user_id INT UNSIGNED,
    time BIGINT,
    image_id_list VARCHAR(50),
    status TINYINT,
    remark INT,
    remark_text VARCHAR(100),
    admin_id INT UNSIGNED,
    result VARCHAR(200),
    repirman_id INT UNSIGNED
);
CREATE TABLE rule
(
    rule_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    unit_price DECIMAL(11,2),
    unit VARCHAR(10),
    description VARCHAR(100),
    overdue_unit_price DECIMAL(11,2),
    overdue_unit VARCHAR(10),
    start_time BIGINT,
    end_time BIGINT
);
CREATE TABLE shop
(
    property_id INT UNSIGNED,
    code VARCHAR(45),
    village_id INT,
    id INT NOT NULL
);
CREATE TABLE tenant
(
    tenant_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    phone VARCHAR(15),
    name VARCHAR(45),
    sex TINYINT,
    birthday BIGINT,
    urgent_name VARCHAR(45),
    urgent_phone VARCHAR(15),
    identity_type TINYINT,
    identity_code VARCHAR(45),
    start_time BIGINT,
    end_time BIGINT,
    authentication_time BIGINT,
    auth_status TINYINT,
    property_id INT UNSIGNED
);
CREATE TABLE village
(
    village_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(45),
    description VARCHAR(100)
);
```