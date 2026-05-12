CREATE TABLE appointments (
    id BIGSERIAL PRIMARY KEY,

    student_id BIGINT NOT NULL,
    lecturer_id BIGINT NOT NULL,

    student_number VARCHAR(20) NOT NULL,
    lecturer_name VARCHAR(100) NOT NULL,

    module_code VARCHAR(20) NOT NULL,
    module_name VARCHAR(100) NOT NULL,

    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,

    mode VARCHAR(20) NOT NULL, -- ONLINE / OFFICE

    meeting_link VARCHAR(255),

    office_location VARCHAR(255),

    reason TEXT,

    status VARCHAR(20) NOT NULL, -- PENDING, APPROVED, REJECTED, COMPLETED

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);