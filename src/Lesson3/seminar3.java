package Lesson3;

// Задание 1 (тайминг 5 минут)
// 1.Реализуем простой односвязный список.
// 2.Пишем только структуру, никаких методов не требуется.
// public class seminar3 {
//     private Node head;

//     private class Node {
//         private Node next;
//         private int value;
//     }

//     // Задание 2 (тайминг 10 минут)
//     // 1.Реализуем метод добавления новых элементов в начало списка и удаление
//     // первого элемента связного списка.
//     // 2.Односвязный список всегда имеет ссылку на первый элемент
//     // последовательности, потому именно с реализации
//     // методов для первого элемента последовательности стоит начать
//     public void addFirst(int value) {
//         Node node = new Node();
//         node.value = value;
//         if (head != null) {
//             node.next = head;
//         }
//         head = node;
//     }

//     public void removeFirst() {
//         if (head != null) {
//             head = head.next;
//         }
//     }

//     // Задание 3 (тайминг 10 минут)
//     // 1.Реализуем метод поиска элемента в односвязном списке для проверки наличия
//     // элемента внутри списка.
//     // 2.Для корректной работы со связным список необходимо понимать, как именно
//     // можно обходить
//     // все значения внутри связного списка.
//     // 3.Для нашего примера проще всего будет написать метод поиска значения в
//     // связном списке и
//     // возвращения из метода информации о наличии искомого внутри списка.
//     public boolean contains(int value) {
//         Node node = head;
//         while (node != null) {
//             if (node.value == value) {
//                 return true;
//             }
//             node = node.next;
//         }
//         return false;
//     }

//     // Задание 4 (тайминг 10 минут)
//     // 1.Реализуем метод добавления новых элементов в конец списка и удаление
//     // последнего элемента связного списка.
//     // 2.Теперь, когда мы понимаем, как можно искать значения внутри связного
//     // списка, мы можем сделать методы добавления и удаления элементов в конец
//     // нашего
//     // односвязного списка.
//     public void addLast(int value) {
//         Node node = new Node();
//         node.value = value;
//         if (head == null) {
//             head = node;
//         } else {
//             Node last = head;
//             while (last.next != null) {
//                 last = last.next;
//             }
//             last.next = node;
//         }
//     }

//     public void removeLast() {
//         if (head != null) {
//             Node node = head;
//             while (node.next != null) {
//                 if (node.next == null) {
//                     node.next = null;
//                     return;
//                 }
//                 node = node.next;
//             }
//             head = null;
//         }
//     }
// }

// Задание 5 (тайминг 5 минут)
// 1.Расширяем структуру связного списка до двухсвязного.
// 2.Мы научились работать с односвязным список, теперь можно ближе
// познакомиться со структурой двухсвязного списка и особенностей его
// внутреннего строения.
// 3.Стоит напомнить, что двухсвязный список представляет из себя цепочку
// элементов, которые умеют ссылаться не только на следующий элемент
// последовательности, но и на предыдущий.
// 4.Вносить корректировки в уже готовые методы на текущий момент не стоит, их
// модификацией мы займемся позднее

// Задание 6 (тайминг 10 минут)
// 1.Обновляем методы согласно новой структуре.
// 2.Появилась дополнительная переменная, которую необходимо отслеживать во
// всех операциях.
// 3.Так же благодаря ссылке на последний элемент списка операции работы с
// концом стали проще и их стоит заменить на логику аналогичную работе с началом
// списка
public class seminar3 {
    private Node head;
    private Node tail;

    private class Node {
        private Node next;
        private Node prev;
        private int value;
    }

    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
            head.prev = node;
        } else {
            tail = node;
        }
        head = node;
    }

    public void removeFirst() {
        if (head != null && head.next != null) {
            head.next.prev = null;
            head = head.next;
        } else {
            head = null;
            tail = null;
        }
    }

    public boolean contains(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void addLast(int value) {
        Node node = new Node();
        node.value = value;
        if (tail != null) {
            node.prev = tail;
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
    }

    public void removeLast() {
        if (tail != null && tail.prev != null) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            head = null;
            tail = null;
        }
    }
}
