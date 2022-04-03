extends Node2D

# Resources
var meteor_res:Resource = preload("res://scene/meteor.tscn")


func _ready():
	
#	spawn_meteors()
	
	return


func spawn_meteors():
	
	for i in range(10):
		
		var meteor := spawn_meteor()
		
		# Spawning meteor every two seconds
		yield(get_tree().create_timer(2.0), "timeout")
		
		add_child(meteor)
	
	return


func spawn_meteor() -> Meteor:
	
	# Spawning meteor
	var meteor:Meteor = meteor_res.instance()
	
	# Position
	position = Vector2(440, 397)
	
	return meteor
