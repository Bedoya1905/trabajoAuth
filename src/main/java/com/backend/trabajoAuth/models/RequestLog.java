package com.backend.trabajoAuth.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class RequestLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "method")
    private String method;
    @Column(name = "path")
    private String path;
    @Column(name = "ip")
    private String ip;
    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    public RequestLog() {}

    public RequestLog(String method, String path, String ip, LocalDateTime timestamp) {
        this.method = method;
        this.path = path;
        this.ip = ip;
        this.timestamp = timestamp;
    }

    public Long getId() { return id; }
    public String getMethod() { return method; }
    public String getPath() { return path; }
    public String getIp() { return ip; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return String.format(
                "RequestLog[id=%d, method='%s', path='%s', ip='%s', timestamp='%s']",
                id, method, path, ip, timestamp.toString());
    }
}
