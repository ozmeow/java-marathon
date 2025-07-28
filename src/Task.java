public class Task {

    private int id; //уникальный идентификатор
    private String title; //описание задачи
    private boolean isDone; //статус выполнения

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.isDone = false;
    }

    public int getId() {
        return id; //нужен для поиска/удаления задач
    }

    public String getTitle() {
        return title; //нужен для поиска/удаления задач
    }

    public boolean isDone() {
        return isDone; //для проверки статуса
    }

    public void setDone(boolean done) {
        isDone = done; //для изменения статуса
    }
}


