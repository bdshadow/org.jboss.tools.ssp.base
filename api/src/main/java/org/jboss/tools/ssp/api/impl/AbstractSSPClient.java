package org.jboss.tools.ssp.api.impl;

import org.jboss.tools.ssp.api.SSPClient;
import org.jboss.tools.ssp.api.SSPServer;

/**
 * @author Dmitrii Bocharov <bdshadow@gmail.com>
 */
public class AbstractSSPClient implements SSPClient {

  private SSPServer server;

  @Override
  public void initialize(SSPServer server) {
    this.server = server;
  }

  @Override
  public SSPServer getProxy() {
    return server;
  }
}
