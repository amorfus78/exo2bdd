CREATE MATERIALIZED VIEW task_per_project AS
SELECT projet.projet_id, COUNT(task.task_id) FROM task
JOIN projet ON task.projet_id = projet.projet_id
GROUP BY projet.projet_id;