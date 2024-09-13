//package Quiz.ch19.Number7;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.List;
//import java.util.Vector;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class ProductServer {
//    private ServerSocket serverSocket;
//    private ExecutorService threadPool;
//    private List<Product> products;
//    private int sequence;
//
//    public void start() throws IOException {
//        serverSocket = new ServerSocket(50001);
//        threadPool = Executors.newFixedThreadPool(100);
//        products = new Vector<>();
//
//        System.out.println("Product Server Started....");
//
//        while (true) {
//            Socket socket = serverSocket.accept();
//            SocketClient sc = new SocketClient(socket);
//        }
//    }
//
//    public void stop() {
//        try {
//            serverSocket.close();
//            threadPool.shutdownNow();
//            System.out.println("Product Server Closed....");
//        } catch (IOException e) {
//        }
//    }
//
//    class SocketClient {
//        private Socket socket;
//        private DataInputStream dis;
//        private DataOutputStream dos;
//
//        public SocketClient(Socket socket) {
//            try {
//                this.socket = socket;
//                dis = new DataInputStream(socket.getInputStream());
//                dos = new DataOutputStream(socket.getOutputStream());
//                receive();
//            } catch (IOException e) {
//                close();
//            }
//        }
//
//        public void receive() {
//            threadPool.execute(() -> {
//                try {
//                    while (true) {
//                        String readJson = dis.readUTF();
//                        JSONObject jsonObject = new JSONObject(readJson);
//                        int menu = jsonObject.getInt("menu");
//
//                        switch (menu) {
//                            case 0 -> list();
//                            case 1 -> create(jsonObject);
//                            case 2 -> update(jsonObject);
//                            case 3 -> delete(jsonObject);
//                        }
//                    }
//                } catch (IOException e) {
//                    close();
//                }
//            });
//        }
//
//        public void list() throws IOException {
//            JSONArray data = new JSONArray();
//
//            for (Product p : products) {
//                JSONObject product = new JSONObject();
//                product.put("no", p.getNo());
//                product.put("name", p.getName());
//                product.put("price", p.getPrice());
//                product.put("stock", p.getPrice());
//
//                data.put(product);
//            }
//
//            JSONObject response = new JSONObject();
//            response.put("status", "success");
//            response.put("data", data);
//            String responseString = response.toString();
//
//            dos.writeUTF(responseString);
//            dos.flush();
//        }
//
//        public void create(JSONObject request) throws IOException {
//            JSONObject data = request.getJSONObject("data");
//
//            Product product = new Product();
//            product.setNo(++sequence);
//            product.setName(data.getString("name"));
//            product.setPrice(data.getInt("price"));
//            product.setStock(data.getInt("stock"));
//            products.add(product);
//
//            JSONObject response = new JSONObject();
//            response.put("status", "success");
//            response.put("data", new JSONObject());
//            dos.writeUTF(response.toString());
//            dos.flush();
//        }
//
//        public void update(JSONObject request) throws IOException{
//            JSONObject data = request.getJSONObject("data");
//            int no = data.getInt("no");
//
//            Product product = products.stream()
//                    .filter(x -> x.getNo() == no)
//                    .findFirst()
//                    .orElse(null);
//            product.setName(data.getString("name"));
//            product.setStock(data.getInt("stock"));
//            product.setPrice(data.getInt("price"));
//
//            JSONObject response = new JSONObject();
//            response.put("status", "success");
//            response.put("data", new JSONObject());
//            dos.writeUTF(response.toString());
//            dos.flush();
//        }
//
//        public void delete(JSONObject request) throws IOException{
//            JSONObject data = request.getJSONObject("data");
//            int no = data.getInt("no");
//
//            products.stream().filter(x -> x.getNo() == no).findFirst().ifPresent(x -> products.remove(x));
//
//            JSONObject response = new JSONObject();
//            response.put("status", "success");
//            response.put("data", new JSONObject());
//            dos.writeUTF(response.toString());
//            dos.flush();
//        }
//
//        public void close() {
//            try {
//                socket.close();
//            } catch (IOException e) {
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        ProductServer productServer = new ProductServer();
//        try {
//            productServer.start();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            productServer.stop();
//        }
//    }
//}
