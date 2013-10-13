package org.wickedsource.hooked.svn;

import org.wickedsource.hooked.plugins.collector.api.CollectorPlugin;

import java.util.HashSet;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.Set;

/**
 * @author Tom Hombergs <tom.hombergs@gmail.com>
 */
public enum PluginRegistry {

    INSTANCE;

    public Set<CollectorPlugin> getCollectorPlugins() {
        ServiceLoader<CollectorPlugin> loader = ServiceLoader.load(CollectorPlugin.class);
        Set<CollectorPlugin> plugins = new HashSet<CollectorPlugin>();
        Iterator<CollectorPlugin> iterator = loader.iterator();
        while (iterator.hasNext()) {
            plugins.add(iterator.next());
        }
        return plugins;
    }
}