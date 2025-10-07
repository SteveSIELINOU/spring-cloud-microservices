DROP TABLE IF EXISTS bookings;

CREATE TABLE bookings (
                          id              BIGSERIAL PRIMARY KEY,
                          record_locator  VARCHAR(8)  NOT NULL UNIQUE,
                          flight_number   VARCHAR(10) NOT NULL,
                          origin          VARCHAR(3)  NOT NULL,
                          destination     VARCHAR(3)  NOT NULL,
                          departure_date  DATE        NOT NULL,
                          seat_count      INTEGER     NOT NULL CHECK (seat_count >= 1),
                          person_type     VARCHAR(10) NOT NULL CHECK (person_type IN ('ADULT','CHILD')),
                          total_fare      NUMERIC(15,2) NOT NULL CHECK (total_fare >= 0),
                          currency        CHAR(3)     NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_bookings_flight_date
    ON bookings (flight_number, departure_date);

CREATE INDEX IF NOT EXISTS idx_bookings_od_date
    ON bookings (origin, destination, departure_date);
