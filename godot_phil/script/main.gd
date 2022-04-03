extends Node


# Declare member variables here. Examples:
# var a = 2
# var b = "text"

# Node Path
export var map_path:NodePath

# Nodes
onready var map:Node2D = get_node(map_path)


# Called when the node enters the scene tree for the first time.
func _ready():
	return

func _physics_process(delta):
	
	if Input.is_action_just_released("ui_rotate"):
		
		var time = 1.0
		var nb_steps = 100
		var dt = time/nb_steps
		var dtheta = -PI/2 * 1/nb_steps
		
		for i in range(nb_steps):
			
			map.rotate(dtheta)
			map.position += get_dtranslation(map.rotation, -dtheta)
			print(map.rotation)
			print(get_translation(map.rotation))
			
			
			# Waiting
			yield(get_tree().create_timer(dt), "timeout")
		
	
	
	return


func get_dtranslation(theta, prev_theta):
	return get_translation(theta) - (get_translation(theta + prev_theta) if !is_equal_approx(theta, 0) else Vector2(0, 0))

func get_translation(theta):
	return Vector2(800, 450) - Vector2(cos(theta) * 800 - sin(theta) * 450, +sin(theta) * 800 + cos(theta) * 450)

# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass
