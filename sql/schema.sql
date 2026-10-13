CREATE TABLE shipments (
 id BIGINT PRIMARY KEY AUTO_INCREMENT,
 booked_at DATETIME NOT NULL,
 origin VARCHAR(100) NOT NULL,
 destination VARCHAR(100) NOT NULL,
 carrier VARCHAR(100) NOT NULL,
 weight_kg DECIMAL(10,3) NOT NULL,
 total_rate DECIMAL(12,2) NOT NULL,
 status VARCHAR(30) NOT NULL,
 INDEX idx_shipments_booked_at (booked_at),
 INDEX idx_shipments_route_status (origin, destination, status)
);

-- MySQL 8+ reporting query using CTEs and a half-open date range.
WITH filtered AS (
 SELECT DATE(booked_at) AS booking_day, origin, destination, total_rate
 FROM shipments
 WHERE booked_at >= ? AND booked_at < ? AND status <> 'CANCELLED'
), daily_route AS (
 SELECT booking_day, origin, destination, COUNT(*) AS shipment_count, SUM(total_rate) AS revenue
 FROM filtered GROUP BY booking_day, origin, destination
)
SELECT booking_day, origin, destination, shipment_count, revenue
FROM daily_route ORDER BY booking_day, origin, destination;
