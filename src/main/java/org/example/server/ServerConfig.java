package org.example.server;

public class ServerConfig {
    private int port;
    private String scriptLocation;
    private String workingDirectory;
    private String serverName;
    private String packageName;
    private ServerConfig() {
        // Private constructor to enforce the use of the builder
    }
    public static class ServerConfigBuilder{
        private int port;
        private String scriptLocation;
        private String workingDirectory;
        private String serverName;
        private String packageName;

        public ServerConfigBuilder setPort(int port) {
            this.port = port;
            return this;
        }

        public ServerConfigBuilder setScriptLocation(String scriptLocation) {
            this.scriptLocation = scriptLocation;
            return this;
        }

        public ServerConfigBuilder setWorkingDirectory(String workingDirectory) {
            this.workingDirectory = workingDirectory;
            return this;
        }

        public ServerConfigBuilder setServerName(String serverName) {
            this.serverName = serverName;
            return this;
        }
        public ServerConfigBuilder setPackageName(String packageName) {
            this.packageName = packageName;
            return this;
        }

        public ServerConfig build() {
            ServerConfig config = new ServerConfig();
            config.port = this.port;
            config.scriptLocation = this.scriptLocation;
            config.workingDirectory = this.workingDirectory;
            config.serverName = this.serverName;
            config.packageName = this.packageName;
            return config;
        }
    }
}
