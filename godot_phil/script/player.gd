extends KinematicBody2D


# Declare member variables here. Examples:
# var a = 2
# var b = "text"
const GRAVITY = 200.0


# Called when the node enters the scene tree for the first time.
func _ready():
	
	return

func get_input():
	
	if Input.is_key_pressed(KEY_D):
		
		self.position += Vector2(128, 0) # TODO fix thise with delta
		
		return
	
	return


func _physics_process(delta):
	
	move_and_collide(Vector2(0, GRAVITY*delta))
	
	# get_input()
	
	return


func _on_Area2D_area_entered(area):
	
	print("test")
	
	pass # Replace with function body.


func _on_Area2D_body_shape_entered(body_rid, body, body_shape_index, local_shape_index):
	print("test")
	pass # Replace with function body.
