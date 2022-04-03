extends KinematicBody2D


# Declare member variables here. Examples:
# var a = 2
# var b = "text"

const GRAVITY = 400.0
var vx
var vy
var acc_x
var acc_y = 0.01

const FLOOR_NORMAL: = Vector2.UP

export var speed: = Vector2(400.0, 900.0)
export var gravity: = 3500.0

var _velocity: = Vector2.ZERO
func _physics_process(delta: float) -> void:
	_velocity.y += gravity * delta
	var is_jump_interrupted: =  _velocity.y < 0.0
	var direction: = get_direction()
	_velocity = calculate_move_velocity(_velocity, direction, speed, is_jump_interrupted)
	var snap: Vector2 = Vector2.DOWN * 60.0 if direction.y == 0.0 else Vector2.ZERO
	_velocity = move_and_slide_with_snap(
		_velocity, snap, FLOOR_NORMAL, true
	)

func get_direction() -> Vector2:
	var dx = 0
	var dy = 0
	if (Input.is_key_pressed(KEY_D)):
		dx = 1
	if (Input.is_key_pressed(KEY_Q)):
		dx=-1
	if (Input.is_key_pressed(KEY_Z) and is_on_floor()):
		dy=-1
	return Vector2(dx,dy)


func calculate_move_velocity(
		linear_velocity: Vector2,
		direction: Vector2,
		speed: Vector2,
		is_jump_interrupted: bool
	) -> Vector2:
	var velocity: = linear_velocity
	velocity.x = speed.x * direction.x
	if direction.y != 0.0:
		velocity.y = speed.y * direction.y
	if is_jump_interrupted:
		velocity.y = 0.0
	return velocity


func calculate_stomp_velocity(linear_velocity: Vector2, stomp_impulse: float) -> Vector2:
	var stomp_jump: = -speed.y if Input.is_action_pressed("jump") else -stomp_impulse
	return Vector2(linear_velocity.x, stomp_jump)
