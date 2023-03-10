import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {
	//Processleri onceliklerine gore ekleyecegimiz kuyruklar
    public Queue<Process> priorityQueue0; 
    public Queue<Process> priorityQueue1;
    public Queue<Process> priorityQueue2; 
    public Queue<Process> priorityQueue3;


    //Zaman asimina ugrayan process listesidir. Dongu icerisinde direkt silerken sikinti yasadigimiz icin boyle bir kuyruk olusturduk.
    //Dongu icine listeye eklilyoruz dongunun sonunda donguden siliyoruz.
    private Queue<Process> removeList;


    public Scheduler() {
        priorityQueue0 = new LinkedList<>();
        priorityQueue1 = new LinkedList<>();
        priorityQueue2 = new LinkedList<>();
        priorityQueue3 = new LinkedList<>();

        removeList = new LinkedList<>();
    }

    public void addProcess(Process p) {
    	//Processleri onceliklerine gore kuyruklara ekleme islemini bu method yapiyor
    	
        if (p.getArrivalTime() == Dispatcher.currentTime) {
            if (p.getPriority() == 0)
                priorityQueue0.offer(p);
            else if (p.getPriority() == 1)
                priorityQueue1.offer(p);
            else if (p.getPriority() == 2)
                priorityQueue2.offer(p);
            else if (p.getPriority() == 3)
                priorityQueue3.offer(p);
        }
    }

    public void timeOut() { //Calistiktan sonra 20 saniyedir bekleyen processlerin zaman asimina burada ugratiyoruz
        for (var item : priorityQueue0) {
            if (item.isTimeOut()) {
                item.setWaitingTime(item.getWaitingTime() + 1);
                if (item.getWaitingTime() == 20) {
                    removeList.add(item);
                    System.out.println(item.getColor()+ Dispatcher.currentTime + " sn proses zaman aşımına uğradı (id:" + item.getId() + " Oncelik:" + item.getPriority() + " kalan sure:" + item.getProcessTime() + " sn)\n");
                }
            }
        }
        priorityQueue0.removeAll(removeList);
        removeList.clear();

        for (var item : priorityQueue1) {
            if (item.isTimeOut()) {
                item.setWaitingTime(item.getWaitingTime() + 1);
                if (item.getWaitingTime() == 20) {
                    removeList.add(item);
                    System.out.println(item.getColor()+Dispatcher.currentTime + " sn proses zaman aşımına uğradı (id:" + item.getId() + " Oncelik:" + item.getPriority() + " kalan sure:" + item.getProcessTime() + " sn)\n");

                }
            }
        }
        priorityQueue1.removeAll(removeList);
        removeList.clear();

        for (var item : priorityQueue2) {
            if (item.isTimeOut()) {
                item.setWaitingTime(item.getWaitingTime() + 1);
                if (item.getWaitingTime() == 20) {
                    removeList.add(item);
                    System.out.println(item.getColor()+Dispatcher.currentTime + " sn proses zaman aşımına uğradı (id:" + item.getId() + " Oncelik:" + item.getPriority() + " kalan sure:" + item.getProcessTime() + " sn)\n");

                }
            }
        }
        priorityQueue2.removeAll(removeList);
        removeList.clear();

        for (var item : priorityQueue3) {
            if (item.isTimeOut()) {
                item.setWaitingTime(item.getWaitingTime() + 1);
                if (item.getWaitingTime() == 20) {
                    removeList.add(item);
                    System.out.println(item.getColor()+Dispatcher.currentTime + " sn proses zaman aşımına uğradı (id:" + item.getId() + " Oncelik:" + item.getPriority() + " kalan sure:" + item.getProcessTime() + " sn)\n");
                }
            }
        }
        priorityQueue3.removeAll(removeList);
        removeList.clear();

    }
}
