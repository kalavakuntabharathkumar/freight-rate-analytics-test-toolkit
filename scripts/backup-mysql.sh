#!/usr/bin/env bash
set -euo pipefail
: "${MYSQL_DATABASE:?Set MYSQL_DATABASE}" "${MYSQL_USER:?Set MYSQL_USER}" "${MYSQL_PASSWORD:?Set MYSQL_PASSWORD}"
MYSQL_HOST="${MYSQL_HOST:-127.0.0.1}"; MYSQL_PORT="${MYSQL_PORT:-3306}"; BACKUP_DIR="${BACKUP_DIR:-./backups}"
mkdir -p "$BACKUP_DIR"
out="$BACKUP_DIR/${MYSQL_DATABASE}_$(date +%Y%m%d_%H%M%S).sql.gz"
export MYSQL_PWD="$MYSQL_PASSWORD"
mysqldump --host="$MYSQL_HOST" --port="$MYSQL_PORT" --user="$MYSQL_USER" --single-transaction --routines --triggers "$MYSQL_DATABASE" | gzip > "$out"
unset MYSQL_PWD
echo "Backup written: $out"
