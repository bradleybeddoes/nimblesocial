class NimblesocialGrailsPlugin {
    // the plugin version
    def version = "0.4"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.2-M3 > *"
    // the other plugins this plugin depends on
    def dependsOn = [nimble:"0.4-SNAPSHOT > *"]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def author = "Bradley Beddoes, Mike Wille, Chris Doty and open source contributors"
    def authorEmail = "nimbleproject@googlegroups.com"
    def title = "Nimble Social"
    def description = '''\\
    NimbleSocial, A complimentary set of social web functionality for Nimble, an extensive application base for Grails.
'''

    // URL to the plugin's documentation
    def documentation = "http://sites.google.com/site/nimbledoc/"

    def doWithWebDescriptor = { xml ->
    }

    def doWithSpring = {
    }

    def doWithDynamicMethods = { ctx ->
    }

    def doWithApplicationContext = { applicationContext ->
    }

    def onChange = { event ->
    }

    def onConfigChange = { event ->
    }
}
