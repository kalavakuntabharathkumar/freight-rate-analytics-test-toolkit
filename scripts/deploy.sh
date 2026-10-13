#!/usr/bin/env bash
set -euo pipefail
APP_DIR="${APP_DIR:-/opt/freight-toolkit}"
ARTIFACT="${1:-target/freight-rate-analytics-test-toolkit-1.0.0.jar}"
[[ -f "$ARTIFACT" ]] || { echo "Artifact not found: $ARTIFACT" >&2; exit 1; }
mkdir -p "$APP_DIR/releases"
release="$APP_DIR/releases/$(date +%Y%m%d%H%M%S)"
mkdir -p "$release"
cp "$ARTIFACT" "$release/app.jar"
ln -sfn "$release" "$APP_DIR/current"
echo "Staged release at $release (service restart intentionally left to deployment owner)."
