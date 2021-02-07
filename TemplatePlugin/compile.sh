plugin_name='template_plugin'
jar_name='TemplatePlugin.jar'

javac -Xlint -cp ../../Spigot/Spigot-API/target/spigot-api-1.16.5-R0.1-SNAPSHOT-shaded.jar $plugin_name/*.java

jar cvf $jar_name $plugin_name/*.class plugin.yml

#rm -r $plugin_name/*.class

#rm ../plugins/$jar_name

cp $jar_name ../../plugins
