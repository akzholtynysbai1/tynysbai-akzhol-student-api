# Tynysbai Akzhol Student API
Student: Akzhol Tynysbai | Group: IT2-2306 | Student ID: 38313 | Course: DevOps | Documentation: see API section below

## CRUD API (author: Akzhol Tynysbai)
- `GET /api/students` - get all students
- `GET /api/students/{id}` - get one student (404 if not found)
- `POST /api/students` - create a student
- `PUT /api/students/{id}` - update a student (added in feature/tynysbai-akzhol-crud)
- `DELETE /api/students/{id}` - delete a student

## CI/CD (Jenkins)
- Job: Tynysbai_Akzhol_Student_API
- Stages: Checkout -> Build -> Test -> Docker Build -> Verify
- Trigger: Poll SCM every 2 minutes
- Automatic build test: Thu Oct 29 23:28:33 +05 2026
