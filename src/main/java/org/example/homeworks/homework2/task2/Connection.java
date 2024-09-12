package org.example.homeworks.homework2.task2.connections;

import java.util.UUID;

/**
 * 2 Создайте класс Connection с полями id (уникальный), host, port и protocol и двух наследников:FastConnectionи SlowConnection.
 * FastConnection лёгкий, поэтому каждому из классов, запрашивающих экземпляр FastConnection, выдаётся новый экземпляр,
 * имеющий те же характеристики, что и ранее созданный (паттерн prototype). Класс SlowConnection тяжёлый, поэтому он
 *  создаётся в единственном экземпляре и следует паттерну singleton.
 */
public class Connection {
    UUID id;
    String host;
    int port;
    String protocol;

    public Connection(UUID id, String host, int port, String protocol) {
        this.id = id;
        this.host = host;
        this.port = port;
        this.protocol = protocol;
    }
}
