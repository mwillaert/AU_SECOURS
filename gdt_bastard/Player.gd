extends KinematicBody2D

signal exit_screen
# Declare member variables here. Examples:
# var a = 2
# var b = "text"

export (int) var speed = 900
export (int) var jump_speed = -2400
export (int) var gravity = 300

var velocity = Vector2.ZERO

export (float, 0, 1.0) var friction = 0.6
export (float, 0, 1.0) var acceleration = 0.25

# Called when the node enters the scene tree for the first time.
func _ready():
	pass # Replace with function body.

func get_input():
	var dir = 0
	if Input.is_action_pressed("move_right"):
		dir += 1
	if Input.is_action_pressed("move_left"):
		dir -= 1
	if dir != 0:
		velocity.x = lerp(velocity.x, dir * speed, acceleration)
	else:
		velocity.x = lerp(velocity.x, 0, friction)

func _physics_process(delta):
	get_input()
	#velocity += Vector2.DOWN.rotated(orientation*PI/2.0)*gravity * delta
	velocity.y += gravity
	#velocity = move_and_slide(velocity, Vector2.UP.rotated(orientation*PI/2))
	if Input.is_action_just_pressed("move_up"):
		if is_on_floor():
			velocity.y = jump_speed
	velocity = move_and_slide(velocity, Vector2.UP)


# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass



func _on_VisibilityNotifier2D_screen_exited():
	emit_signal("exit_screen")
