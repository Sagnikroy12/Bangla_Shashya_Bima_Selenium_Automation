Run tests in Docker with Excel data mounted from another directory

1) Prepare host Excel folder
   - Create a folder on your host (example: `D:\excel-data`) and place `MEMARI - I.xlsx` inside it.

2) Quick run (PowerShell):
   ```powershell
   .\run-tests.ps1 -ExcelHostDir 'D:\excel-data' -Email 'you@example.com' -Password 'yourpass'
   ```

3) Quick run (WSL / Bash):
   ```bash
   ./run-tests.sh /mnt/d/excel-data you@example.com yourpass
   ```

4) Using docker-compose (optional):
   - Create a `.env` file with `EXCEL_HOST_DIR` and `BSB_EMAIL`/`BSB_PASSWORD` or pass envs.
   - Run:
   ```bash
   EXCEL_HOST_DIR=D:\excel-data BSB_EMAIL=you@example.com BSB_PASSWORD=yourpass docker-compose up --abort-on-container-exit
   ```

5) Results
   - Test reports will be in `target/surefire-reports` on the host (mapped from the container).

Notes
- If Docker on Windows has path-mount issues, prefer WSL or use a local path under the Docker shared drives.
- `-Ddata.dir=/data` points the test suite to the mounted Excel folder.
- Keep credentials secure; prefer using an environment file for CI.
