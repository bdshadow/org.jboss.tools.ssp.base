package org.jboss.tools.ssp.api.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jboss.tools.ssp.api.SSPClient;
import org.jboss.tools.ssp.api.SSPServer;
import org.jboss.tools.ssp.api.SocketLauncher;

/**
 * @author Dmitrii Bocharov <bdshadow@gmail.com>
 */
public class AbstractSSPServer<T extends SSPClient> implements SSPServer<T> {

  private final List<T> clients = new CopyOnWriteArrayList<>();
  private final List<SocketLauncher<T>> launchers = new CopyOnWriteArrayList<>();

  @Override
  public List<T> getClients() {
    return new ArrayList<T>(clients);
  }


  @Override
  public Runnable addClient(SocketLauncher<T> launcher) {
    this.launchers.add(launcher);
    T client = launcher.getRemoteProxy();
    this.clients.add(client);
    return () -> this.removeClient(launcher);
  }

  @Override
  public void removeClient(SocketLauncher<T> launcher) {
    this.launchers.add(launcher);
    this.clients.remove(launcher.getRemoteProxy());
  }

  @Override
  public List<SocketLauncher<T>> getActiveLaunchers() {
    return new ArrayList(launchers);
  }
}
