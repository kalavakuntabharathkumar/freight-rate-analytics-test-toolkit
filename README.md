# Freight Rate Analytics and Test Automation Toolkit
Java 17 · JUnit 5 · Mockito · MySQL 8+ · CTEs · Bash · Maven · Jenkins

## Run tests
Install JDK 17+ and Maven 3.9+, then run `mvn clean test`.

## Components
- `RateQuote`: validates freight quote inputs and calculates the final rate.
- `RateCalculator`: calculates a quote and chooses the cheapest carrier.
- `RateReportService`: validates date ranges and delegates reporting to a repository boundary.
- `sql/schema.sql`: MySQL table/index example and CTE report grouped by day and route.
- `scripts/deploy.sh`: stages a JAR in a timestamped release directory.
- `scripts/backup-mysql.sh`: creates a compressed logical MySQL backup.
- `Jenkinsfile`: runs tests, packages, archives artifacts and publishes JUnit results.

## SQL performance
The query filters using a half-open date range, excludes cancelled shipments, aggregates by day and route, and sorts results deterministically. Index selection should be validated with `EXPLAIN ANALYZE` and representative data before claiming performance improvements.

## Script examples
```bash
chmod +x scripts/*.sh
mvn -DskipTests package
./scripts/deploy.sh target/freight-rate-analytics-test-toolkit-1.0.0.jar
MYSQL_DATABASE=freight MYSQL_USER=reporter MYSQL_PASSWORD='...' ./scripts/backup-mysql.sh
```
The deploy script stages the artifact but intentionally does not restart a live service. Use secret management, backup retention, restore drills and service health checks for production.

## Honest project metrics
The included tests are examples, not a claim of 85 tests or 88% coverage. Add broader unit/integration tests and a coverage tool, then measure your actual results before using resume metrics.
